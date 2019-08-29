package org.koushik.javabrains.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	//this runs advice for all getName() methods of all classes
		@Before("execution(public String getName())")
		public void loggingAdvice(){
			System.out.println("Advice run. Get method called");
		}

	//this runs advice for getName() method of Circle class only
	//	@Before("execution(public String org.koushik.javabrains.Circle.getName())")
	//	public void loggingAdvice(){
	//		System.out.println("Advice run. Get method called");
	//	}

	//All getters with any return type
//	@Before("allGetters() && allCircleMethods()")
//	public void loggingAdvice(){
//		System.out.println("Advice run. Get method called");
//	}

	//All getters with any return type
//	@Before("allGetters()")
//	public void secondAdvice(){
//		System.out.println("Second advice executed");
//	}
	
//	@After("allGetters()")
//	public void afterAdvice(JoinPoint jp){
//		System.out.println("after advice executed for "+jp.toString());
//	}
	
	@AfterReturning(pointcut="args(name)", returning="returnObject")
	public void afterReturningAdvice(String name, String returnObject){
		System.out.println("after returning advice executed! Input arg is "+name+ " Return object is "+ returnObject );
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void afterThrowingAdvice(String name, Exception ex){
		System.out.println("after throwing advice executed! Input arg is "+name+ " Exception is "+ ex );
	}
	
//	@Around("allGetters()")
//	public void myAroundAdvice(ProceedingJoinPoint pjp){
//		try {
//			System.out.println("Around: Before advice");
//			pjp.proceed();
//			System.out.println("Around : After returning advice");
//		} catch (Throwable e) {
//			System.out.println("Around : Caught exception");
//			e.printStackTrace();
//		}
//		System.out.println("Around : After finally");
//	}
	
	@Around("@annotation(org.koushik.javabrains.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint pjp){
		Object returnValue = null;
		try {
			System.out.println("Around: Before advice");
			returnValue = pjp.proceed();
			System.out.println("Around : After returning advice");
		} catch (Throwable e) {
			System.out.println("Around : Caught exception");
			e.printStackTrace();
		}
		System.out.println("Around : After finally");
		return returnValue;
	}

	//All getters with any return type
	//Example of advice argument
//	@Before("allGetters()")
//	public void thirdAdvice(JoinPoint joinPoint){
//		System.out.println("third advice executed " + joinPoint.getTarget() + " Pointcut expression :" +joinPoint.toString());
//	}
	
	//Example of advice argument
	//This advice will run for all methods which take string argument
//	@Before("args(name)")
//	public void adviceForMethodsWithStringArgument(String name){
//		System.out.println("String argument method advice ran. Argument is "+name);
//	}

	//Used to apply multiple advice which match same Join points
	@Pointcut("execution(public * get*())")
	public void allGetters(){}

	//within is used for having classes defined in pointcut. Below pointcut will run for all methods in Circle class
	@Pointcut("within(org.koushik.javabrains.Circle)")
	public void allCircleMethods(){}

	
	
	
}
