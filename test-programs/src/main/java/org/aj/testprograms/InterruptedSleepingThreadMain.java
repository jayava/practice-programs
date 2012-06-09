package org.aj.testprograms;

public class InterruptedSleepingThreadMain {

	  public static class InterruptedSleepingThread extends Thread {

	        @Override
	        public void run() {
	            doAPseudoHeavyWeightJob();
	        }

	        private void doAPseudoHeavyWeightJob() {
	            for (int i=0;i<Integer.MAX_VALUE;i++) {
	                //You are kidding me
	                System.out.println(i + " " + i*2);
	                //Let me sleep <evil grin>
	                if(Thread.currentThread().isInterrupted()) {
	                    System.out.println("Thread interrupted\n Exiting...");
	                    break;
	                }else {
	                    sleepBabySleep();
	                }
	            }
	        }

	        /**
	         *
	         */
	        protected void sleepBabySleep() {
	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                //e.printStackTrace();
	                //Thread.currentThread().interrupt();
	            }
	        }
	    }

	

	        /**
	         * @param args
	         * @throws InterruptedException
	         */
	        public static void main(String[] args) throws InterruptedException {
	            InterruptedSleepingThread thread = new InterruptedSleepingThread();
	            thread.start();
	            //Giving 10 seconds to finish the job.
	            Thread.sleep(10000);
	            //Let me interrupt
	            thread.interrupt();
	        }

	    
}
