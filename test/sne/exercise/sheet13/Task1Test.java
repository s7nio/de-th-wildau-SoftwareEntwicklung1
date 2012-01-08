/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sne.exercise.sheet13;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sne
 */
public class Task1Test {
    
    public Task1Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFakultaet() {
        System.out.println("testFakultaet");
        Task1 instance = new Task1();
        Assert.assertEquals(1, instance.f(0));
        Assert.assertEquals(1, instance.f(1));
        Assert.assertEquals(2, instance.f(2));
        Assert.assertEquals(6, instance.f(3));
        Assert.assertEquals(24, instance.f(4));
        Assert.assertEquals(120, instance.f(5));
    }
}
