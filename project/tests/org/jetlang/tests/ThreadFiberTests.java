package org.jetlang.tests;

import org.jetlang.fibers.ProcessFiber;
import org.jetlang.fibers.ThreadFiber;
import org.jetlang.core.RunnableExecutorImpl;
import org.jetlang.core.Stopable;
import org.junit.Test;

/**
 * User: mrettig
 * Date: Jul 23, 2008
 * Time: 8:40:58 PM
 */
public class ThreadFiberTests extends FiberBaseTest {

    public ProcessFiber CreateBus() {
        return new ThreadFiber(new RunnableExecutorImpl(), System.currentTimeMillis() + "", true);
    }

    public void DoSetup() {
    }

    public void DoTearDown() {
    }

    @Test
    public void ScheduleIntervalWithCancel() throws InterruptedException {
        _bus.start();
        Runnable onReset = new Runnable() {
            public void run() {
            }
        };
        Stopable stopper = _bus.scheduleOnInterval(onReset, 15, 15);
        assertEquals(0, _bus.stoppableSize());
        stopper.stop();
        assertEquals(0, _bus.stoppableSize());
    }

}