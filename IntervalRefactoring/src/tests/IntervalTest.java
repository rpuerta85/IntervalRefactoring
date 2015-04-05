package tests;

import static org.junit.Assert.*;
import intervals.Interval;
import intervals.IntervalFactory;
import intervals.Opening;

import org.junit.Test;

public class IntervalTest {

	
	@Test
	public void midPointTest() {
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(5, IntervalFactory.getInterval(0, 10, Opening.UNOPENED).midPoint(), 0.0);

		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(0, IntervalFactory.getInterval(-10, 10, Opening.UNOPENED).midPoint(), 0.0);
		
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.BOTH_OPENED).midPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.LEFT_OPENED).midPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.RIGHT_OPENED).midPoint(), 0.0);
		assertEquals(-10, IntervalFactory.getInterval(-15, -5, Opening.UNOPENED).midPoint(), 0.0);
	}

	@Test
	public void includeValueTest() {
		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10, Opening.BOTH_OPENED).includes(-3));
		assertFalse(IntervalFactory.getIntervalLeftOpened(0, 10, Opening.LEFT_OPENED).includes(-3));
		assertFalse(IntervalFactory.getIntervalRightOpened(0, 10, Opening.RIGHT_OPENED).includes(-3));
		assertFalse(IntervalFactory.getIntervalUnOpened(0, 10, Opening.UNOPENED).includes(-3));
		
		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10, Opening.BOTH_OPENED).includes(0));
		assertFalse(IntervalFactory.getIntervalLeftOpened(0, 10, Opening.LEFT_OPENED).includes(0));
		assertTrue(IntervalFactory.getIntervalRightOpened(0, 10, Opening.RIGHT_OPENED).includes(0));
		assertTrue(IntervalFactory.getIntervalUnOpened(0, 10, Opening.UNOPENED).includes(0));

		assertTrue(IntervalFactory.getIntervalBothOpened(0, 10, Opening.BOTH_OPENED).includes(5));
		assertTrue(IntervalFactory.getIntervalLeftOpened(0, 10, Opening.LEFT_OPENED).includes(5));
		assertTrue(IntervalFactory.getIntervalRightOpened(0, 10, Opening.RIGHT_OPENED).includes(5));
		assertTrue(IntervalFactory.getIntervalUnOpened(0, 10, Opening.UNOPENED).includes(5));

		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10, Opening.BOTH_OPENED).includes(10));
		assertTrue(IntervalFactory.getIntervalLeftOpened(0, 10, Opening.LEFT_OPENED).includes(10));
		assertFalse(IntervalFactory.getIntervalRightOpened(0, 10, Opening.RIGHT_OPENED).includes(10));
		assertTrue(IntervalFactory.getIntervalUnOpened(0, 10, Opening.UNOPENED).includes(10));

		
		assertFalse(IntervalFactory.getIntervalBothOpened(0, 10, Opening.BOTH_OPENED).includes(13));
		assertFalse(IntervalFactory.getIntervalLeftOpened(0, 10, Opening.LEFT_OPENED).includes(13));
		assertFalse(IntervalFactory.getIntervalRightOpened(0, 10, Opening.RIGHT_OPENED).includes(13));
		assertFalse(IntervalFactory.getIntervalUnOpened(0, 10, Opening.UNOPENED).includes(13));

	}
	@Test
	public void includeIntervalTest() {
		
		Interval bothOpenedPivot = IntervalFactory.getIntervalBothOpened(20, 35, Opening.BOTH_OPENED);

		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45, Opening.BOTH_OPENED)));

		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45, Opening.LEFT_OPENED)));

		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45, Opening.RIGHT_OPENED)));

		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25, Opening.UNOPENED)));
		assertTrue(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45, Opening.UNOPENED)));

		Interval leftOpenedPivot = IntervalFactory.getIntervalLeftOpened(20, 35, Opening.LEFT_OPENED);
		
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45, Opening.BOTH_OPENED)));

		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45, Opening.LEFT_OPENED)));

		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45, Opening.RIGHT_OPENED)));

		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15, Opening.UNOPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20, Opening.UNOPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35, Opening.UNOPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40, Opening.UNOPENED)));
		assertFalse(leftOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45, Opening.UNOPENED)));

		Interval rightOpenedPivot = IntervalFactory.getIntervalRightOpened(20, 35, Opening.RIGHT_OPENED);
		
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45, Opening.BOTH_OPENED)));

		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45, Opening.LEFT_OPENED)));

		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45, Opening.RIGHT_OPENED)));

		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15, Opening.UNOPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30, Opening.UNOPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35, Opening.UNOPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40, Opening.UNOPENED)));
		assertFalse(rightOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45, Opening.UNOPENED)));

		Interval unopenedOpenedPivot = IntervalFactory.getIntervalUnOpened(20, 35, Opening.UNOPENED);
		
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(10, 15, Opening.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(15, 20, Opening.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(20, 25, Opening.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(25, 30, Opening.BOTH_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(30, 35, Opening.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(35, 40, Opening.BOTH_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalBothOpened(40, 45, Opening.BOTH_OPENED)));

		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(10, 15, Opening.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(15, 20, Opening.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(20, 25, Opening.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(25, 30, Opening.LEFT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(30, 35, Opening.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(35, 40, Opening.LEFT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalLeftOpened(40, 45, Opening.LEFT_OPENED)));

		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(10, 15, Opening.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(15, 20, Opening.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(20, 25, Opening.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(25, 30, Opening.RIGHT_OPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(30, 35, Opening.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(35, 40, Opening.RIGHT_OPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalRightOpened(40, 45, Opening.RIGHT_OPENED)));

		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(10, 15, Opening.UNOPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(15, 20, Opening.UNOPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(20, 25, Opening.UNOPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(25, 30, Opening.UNOPENED)));
		assertTrue(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(30, 35, Opening.UNOPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(35, 40, Opening.UNOPENED)));
		assertFalse(unopenedOpenedPivot.includes(IntervalFactory.getIntervalUnOpened(40, 45, Opening.UNOPENED)));

	}

	
	@Test
	public void hasIntersectionTest() {

		Interval bothOpenedPivot = IntervalFactory.getIntervalBothOpened(20, 40, Opening.BOTH_OPENED);
		
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40, Opening.BOTH_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50, Opening.BOTH_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55, Opening.BOTH_OPENED)));

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40, Opening.LEFT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50, Opening.LEFT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55, Opening.LEFT_OPENED)));

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55, Opening.RIGHT_OPENED)));

		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20, Opening.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25, Opening.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30, Opening.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35, Opening.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40, Opening.UNOPENED)));
		assertTrue(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50, Opening.UNOPENED)));
		assertFalse(bothOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55, Opening.UNOPENED)));

		Interval leftOpenedPivot = IntervalFactory.getIntervalLeftOpened(20, 40, Opening.LEFT_OPENED);
		
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40, Opening.BOTH_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50, Opening.BOTH_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55, Opening.BOTH_OPENED)));

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40, Opening.LEFT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50, Opening.LEFT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55, Opening.LEFT_OPENED)));

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45, Opening.RIGHT_OPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55, Opening.RIGHT_OPENED)));

		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15, Opening.UNOPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45, Opening.UNOPENED)));
		assertTrue(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50, Opening.UNOPENED)));
		assertFalse(leftOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55, Opening.UNOPENED)));

		Interval rightOpenedPivot = IntervalFactory.getIntervalRightOpened(20, 40, Opening.RIGHT_OPENED);
		
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40, Opening.BOTH_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50, Opening.BOTH_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55, Opening.BOTH_OPENED)));

		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40, Opening.LEFT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50, Opening.LEFT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55, Opening.LEFT_OPENED)));

		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55, Opening.RIGHT_OPENED)));

		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40, Opening.UNOPENED)));
		assertTrue(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45, Opening.UNOPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50, Opening.UNOPENED)));
		assertFalse(rightOpenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55, Opening.UNOPENED)));

		Interval unopenedPivot = IntervalFactory.getIntervalUnOpened(20, 40, Opening.UNOPENED);
		
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(5, 15, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(10, 20, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(15, 25, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(20, 30, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(25, 35, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(30, 40, Opening.BOTH_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(35, 45, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(40, 50, Opening.BOTH_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalBothOpened(45, 55, Opening.BOTH_OPENED)));

		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(5, 15, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(10, 20, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(15, 25, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(20, 30, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(25, 35, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(30, 40, Opening.LEFT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(35, 45, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(40, 50, Opening.LEFT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalLeftOpened(45, 55, Opening.LEFT_OPENED)));

		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(5, 15, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(10, 20, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(15, 25, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(20, 30, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(25, 35, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(30, 40, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(35, 45, Opening.RIGHT_OPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(40, 50, Opening.RIGHT_OPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalRightOpened(45, 55, Opening.RIGHT_OPENED)));

		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(5, 15, Opening.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(10, 20, Opening.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(15, 25, Opening.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(20, 30, Opening.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(25, 35, Opening.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(30, 40, Opening.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(35, 45, Opening.UNOPENED)));
		assertTrue(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(40, 50, Opening.UNOPENED)));
		assertFalse(unopenedPivot.intersectsWith(IntervalFactory.getIntervalUnOpened(45, 55, Opening.UNOPENED)));

	}

//	@Test
//	public void intersectionTest() {
//		
//		 Interval bothOpenedPivot = IntervalFactory.getInterval(20, 50, Opening.BOTH_OPENED);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.UNOPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.RIGHT_OPENED),
//				 bothOpenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//		 
//		 Interval unopenedPivot = IntervalFactory.getInterval(20, 50, Opening.UNOPENED);
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.BOTH_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.BOTH_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.LEFT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.LEFT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.LEFT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.RIGHT_OPENED)));
//		 assertEquals(IntervalFactory.getInterval(50, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60, Opening.RIGHT_OPENED)));
//		 
//		 assertEquals(IntervalFactory.getInterval(20, 20, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(10, 20, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 25, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(15, 25, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(20, 30, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(20, 30, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(30, 40, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(30, 40, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(40, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(40, 50, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(45, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(45, 55, Opening.UNOPENED)));
//		 assertEquals(IntervalFactory.getInterval(50, 50, Opening.UNOPENED),
//				 unopenedPivot.intersection(IntervalFactory.getInterval(50, 60, Opening.UNOPENED)));
//		 
//	}

}
