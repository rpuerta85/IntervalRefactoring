package tests;

import static org.junit.Assert.*;
import intervals.Interval;
import intervals.IntervalFactory;

import org.junit.Test;

public class IntervalTest {

	
	
//	@Test
//	public void midPointTest() {
//		assertEquals(5, IntervalFactory.getIntervalBothOpened(0, 10).midPoint(), 0.0);
//		assertEquals(5, IntervalFactory.getIntervalLeftOpened(0, 10).midPoint(), 0.0);
//		assertEquals(5, IntervalFactory.getIntervalRightOpened(0, 10).midPoint(), 0.0);
//		assertEquals(5, IntervalFactory.getIntervalUnOpened(0, 10).midPoint(), 0.0);
//
//		assertEquals(0, IntervalFactory.getIntervalBothOpened(-10, 10).midPoint(), 0.0);
//		assertEquals(0, IntervalFactory.getIntervalLeftOpened(-10, 10).midPoint(), 0.0);
//		assertEquals(0, IntervalFactory.getIntervalRightOpened(-10, 10).midPoint(), 0.0);
//		assertEquals(0, IntervalFactory.getIntervalUnOpened(-10, 10).midPoint(), 0.0);
//		
//		assertEquals(-10, IntervalFactory.getIntervalBothOpened(-15, -5).midPoint(), 0.0);
//		assertEquals(-10, IntervalFactory.getIntervalLeftOpened(-15, -5).midPoint(), 0.0);
//		assertEquals(-10, IntervalFactory.getIntervalRightOpened(-15, -5).midPoint(), 0.0);
//		assertEquals(-10, IntervalFactory.getIntervalUnOpened(-15, -5).midPoint(), 0.0);
//	}
//
//	@Test
//	public void includeValueTest() {
//		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10).includes(-3));
//
//		assertFalse(IntervalFactory.getIntervalLeftOpened(0, 10).includes(-3));
//		assertFalse(IntervalFactory.getIntervalRightOpened(0, 10).includes(-3));
//		assertFalse(IntervalFactory.getIntervalUnOpened(0, 10).includes(-3));
//		
//		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10).includes(0));
//		assertFalse(IntervalFactory.getIntervalLeftOpened(0, 10).includes(0));
//		assertTrue(IntervalFactory.getIntervalRightOpened(0, 10).includes(0));
//		assertTrue(IntervalFactory.getIntervalUnOpened(0, 10).includes(0));
//
//		assertTrue(IntervalFactory.getIntervalBothOpened(0, 10).includes(5));
//		assertTrue(IntervalFactory.getIntervalLeftOpened(0, 10).includes(5));
//		assertTrue(IntervalFactory.getIntervalRightOpened(0, 10).includes(5));
//		assertTrue(IntervalFactory.getIntervalUnOpened(0, 10).includes(5));
//
//		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10).includes(10));
//		assertTrue(IntervalFactory.getIntervalLeftOpened(0, 10).includes(10));
//		assertFalse(IntervalFactory.getIntervalRightOpened(0, 10).includes(10));
//		assertTrue(IntervalFactory.getIntervalUnOpened(0, 10).includes(10));
//
//		
//		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10).includes(13));
//		assertFalse(IntervalFactory.getIntervalLeftOpened(0, 10).includes(13));
//		assertFalse(IntervalFactory.getIntervalRightOpened(0, 10).includes(13));
//		assertFalse(IntervalFactory.getIntervalUnOpened(0, 10).includes(13));
//
//	}
//	@Test
//	public void includeIntervalTest() {
//		
//		
//		Interval bothOpenedPivot = IntervalFactory.getIntervalBothOpened(20, 35);
//
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45)));
//
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45)));
//
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45)));
//
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25)));
//		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40)));
//		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45)));
//
//		Interval leftOpenedPivot = IntervalFactory.getIntervalLeftOpened(20, 35);
//		
//		
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45)));
//
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45)));
//
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20)));
//		
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45)));
//
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30)));
//		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40)));
//		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45)));
//
//		Interval rightOpenedPivot = IntervalFactory.getIntervalRightOpened(20, 35);
//		
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45)));
//
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45)));
//
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45)));
//
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25)));
//		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40)));
//		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45)));
//
//		Interval unopenedOpenedPivot = IntervalFactory.getIntervalUnOpened(20, 35);
//		
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15)));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20)));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25)));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30)));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40)));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45 )));
//
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45 )));
//
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45 )));
//
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30 )));
//		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40 )));
//		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45 )));
//
//	}

	
	@Test
	public void hasIntersectionTest() {

		Interval bothOpenedPivot = IntervalFactory.getIntervalBothOpened(20, 40 );
		
		//assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15 )));
		//assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55 )));

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55 )));

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55 )));

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40 )));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50 )));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55 )));

		Interval leftOpenedPivot = IntervalFactory.getIntervalLeftOpened(20, 40 );
		
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55 )));

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55 )));

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55 )));

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45 )));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50 )));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55 )));

		Interval rightOpenedPivot = IntervalFactory.getIntervalRightOpened(20, 40 );
		
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55 )));

		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55 )));

		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55 )));

		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40 )));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50 )));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55 )));

		Interval unopenedPivot = IntervalFactory.getIntervalUnOpened(20, 40 );
		
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55 )));

		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55 )));

		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55 )));

		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45 )));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50 )));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55 )));

	}

//	@Test
//	public void intersectionTest() {
//		
//		 Interval bothOpenedPivot = IntervalFactory.getInterval(20, 50 );
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 
//		 Interval unopenedPivot = IntervalFactory.getInterval(20, 50 );
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20 )));
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 assertEquals(IntervalFactory.getInterval(50, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60 )));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20 )));
//		 assertEquals(IntervalFactory.getInterval(20, 25 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25 )));
//		 assertEquals(IntervalFactory.getInterval(20, 30 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30 )));
//		 assertEquals(IntervalFactory.getInterval(30, 40 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40 )));
//		 assertEquals(IntervalFactory.getInterval(40, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50 )));
//		 assertEquals(IntervalFactory.getInterval(45, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55 )));
//		 assertEquals(IntervalFactory.getInterval(50, 50 ),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60 )));
//		 
//	}

}
