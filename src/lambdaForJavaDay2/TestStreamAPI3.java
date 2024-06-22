package lambdaForJavaDay2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;


public class TestStreamAPI3 {

	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 79, 6666.66, Employee.Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Employee.Status.FREE),
			new Employee(103, "王五", 28, 3333.33, Employee.Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.BUSY),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Employee.Status.FREE),
			new Employee(105, "田七", 38, 5555.55, Employee.Status.BUSY)
	);

	//3. 终止操作
	/*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 	*reduce*操作可以实现从一组元素中生成一个值，`sum()`、`max()`、`min()`、`count()`等都是*reduce*操作，
	 	将他们单独设为函数只是因为常用。`reduce()`的方法定义有三种重写形式：
- 		`Optional<T> reduce(BinaryOperator<T> accumulator)`
- 		`T reduce(T identity, BinaryOperator<T> accumulator)`
- 		`<U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)`

	 */
	@Test
	public void test1() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println(list);
		Integer sum = list.stream()
				.reduce(0, (x, y) -> x + y);

		System.out.println(sum);

		System.out.println("----------------------------------------");

		Optional<Double> op = emps.stream()
				.map(Employee::getSalary)
				.reduce(Double::sum);

		System.out.println(op.get());
	}

	//需求：搜索名字中 “六” 出现的次数
	//能否替代sql里的sum？
	@Test
	public void test2() {
		Optional<Integer> sum = emps.stream()
				.map(Employee::getName)
				.flatMap(TestStreamAPI1::filterCharacter)
				.map((ch) -> {
					if (ch.equals('六'))
						return 1;
					else
						return 0;
				}).reduce(Integer::sum);

		System.out.println(sum.get());
	}

	//`reduce()`擅长的是生成一个值，如果想要从*Stream*生成一个集合或者*Map*等复杂的对象该怎么办呢？终极武器`collect()`横空出世！
	//collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
	@Test
	public void test3() {
		List<String> list = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toList());

		list.forEach(System.out::println);

		System.out.println("----------------------------------");

		Set<String> set = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toSet());

		set.forEach(System.out::println);

		System.out.println("----------------------------------");

		HashSet<String> hs = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.toCollection(HashSet::new));

		hs.forEach(System.out::println);
	}

	//
	@Test
	public void test4() {
		Optional<Double> max = emps.stream()
				.map(Employee::getSalary)
				.collect(Collectors.maxBy(Double::compare));


		System.out.println(max.get());

		Optional<Employee> op = emps.stream()
				.collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));

		System.out.println(op.get());

		Double sum = emps.stream()
				.collect(Collectors.summingDouble(Employee::getSalary));

		System.out.println(sum);

		Double avg = emps.stream()
				.collect(Collectors.averagingDouble(Employee::getSalary));

		System.out.println(avg);

		Long count = emps.stream()
				.collect(Collectors.counting());

		System.out.println(count);

		System.out.println("--------------------------------------------");


		//其他收集方式
		DoubleSummaryStatistics dss = emps.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println(dss.getMax());
	}

	//分组groupingBy  partitioningBy分区区别
	//分区是一种特殊的分组，结果 map 至少包含两个不同的分组——一个true，一个false。
	@Test
	public void test5() {
		Map<Employee.Status, List<Employee>> map = emps.stream()
				.collect(Collectors.groupingBy(Employee::getStatus));

		System.out.println(map);
	}

	//多级分组
	@Test
	public void test6() {
		Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
					if (e.getAge() >= 60)
						return "老年";
					else if (e.getAge() >= 35)
						return "中年";
					else
						return "成年";
				})));

		System.out.println(map);
	}

	//分区 nba
	@Test
	public void test7() {
		Map<Boolean, List<Employee>> map = emps.stream()
				.collect(Collectors.partitioningBy((e) -> e.getSalary() >= 5000));

		System.out.println(map);
	}

	//连接  使用collect()做字符串join
	@Test
	public void test8() {
		String str = emps.stream()
				.map(Employee::getName)
				.collect(Collectors.joining(",", "----", "----"));

		System.out.println(str);
	}

	@Test
	public void test9() {
		Optional<Double> sum = emps.stream()
				.map(Employee::getSalary).reduce(Double::sum);

		System.out.println(sum.get());
	}

	@Test
	public void test10() {
		IntStream.range(1, 10)
				.peek(x -> System.out.print("\nA" + x))
				.skip(6)
				.peek(x -> System.out.print("B" + x))
				.forEach(x -> System.out.print("C" + x));
	}


	@Test
	public void test11() {
		List<Employee> list = new ArrayList<>(emps);
		list.add(new Employee(11,"11",11,10.11, Employee.Status.FREE));
		System.out.println(list);

		emps.stream()
				.filter(employee -> "李四".equals(employee.getName()))
				.forEach(emp -> {
					emp.setName("miao");
				});
		System.out.println(list);
		System.out.println(emps);
	}


	@Data
	static class User{
		private String name;

		public User(String name) {
			this.name = name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	@Test
	public void test12(){
		List<User> list = Arrays.asList(new User("a"),new User("b"),new User("c"));
		System.out.println(list);
		List<User> userList= list.stream().map(u -> {
			return new User(u.getName()+u.getName());
		}).collect(Collectors.toList());
		System.out.println(list);
		System.out.println(userList);

	}
}