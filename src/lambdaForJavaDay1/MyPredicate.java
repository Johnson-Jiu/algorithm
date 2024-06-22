package lambdaForJavaDay1;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
