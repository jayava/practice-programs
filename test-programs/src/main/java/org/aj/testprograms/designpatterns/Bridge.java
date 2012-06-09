package org.aj.testprograms.designpatterns;

public class Bridge {
	
	interface CarStyleImp {
		void placeGearBox();
		void placeIgnition();
	}
	
	static class LeftHandDriveCarImp implements CarStyleImp {
		
		LeftHandDriveCarImp() {
			System.out.println("Created Left hand drive car");
		}
		
		@Override
		public void placeGearBox() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void placeIgnition() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	static class RightHandDriveImp implements CarStyleImp {

		@Override
		public void placeGearBox() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void placeIgnition() {
			// TODO Auto-generated method stub
			
		}
		
	}

	interface Car {
		void startAndDrive();
		void stop();
	}
	
	static abstract class AbstractCar implements Car {
		protected final CarStyleImp carStyle;

		AbstractCar(CarStyleImp carStyle) {
			this.carStyle = carStyle;
		}
		
	}
	
	static class Mercedes extends AbstractCar {

		Mercedes(CarStyleImp carStyle) {
			super(carStyle);
		}

		@Override
		public void startAndDrive() {
			System.out.println("Starting Merc!");
		}

		@Override
		public void stop() {
			System.out.println("Stopping Merc");
		}
		
	}
	
	static class Audi extends AbstractCar {

		Audi(CarStyleImp carStyle) {
			super(carStyle);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void startAndDrive() {
			System.out.println("Starting Audi!");
			
		}

		@Override
		public void stop() {
			System.out.println("Stopping Audi!");
		}
		
	}
	
	static class CarStyleFactory {
		private static CarStyleFactory instance;
		private final CarStyleImp theStyle;
		
		private CarStyleFactory(){
			//could be cached into 2 vars... 1 for LH, 1 for RH
			theStyle = new LeftHandDriveCarImp();
		}
		
		static CarStyleFactory getInstance(){
			if(instance == null)
				instance = new CarStyleFactory();
			return instance;
		}
		
		CarStyleImp getCarStyle(){
			return theStyle;
		}
	}
	
	public static void main(String[] args) {
		Car myFirstCar = new Mercedes(CarStyleFactory.getInstance().getCarStyle());
		myFirstCar.startAndDrive();
		myFirstCar.stop();
	}
}
