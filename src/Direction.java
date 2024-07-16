

import java.util.ArrayList;
import java.util.Scanner;

public class Direction {

	private enum DirectionEnum {

		NORTH, SOUTH, WEST, EAST, NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST,

	}

	public static void main(String[] args) {

		ArrayList<City> cities = new ArrayList<>();

		City city1 = new City("New York", 40.7128, -74.0060);
		City city2 = new City("Los Angeles", 34.0522, -118.2437);
		City city3 = new City("Seatlle", 47.6062, -122.3321);
		City city4 = new City("Chigago", 41.8781, -87.6298);
		City city5 = new City("Austin", 30.2672, -97.7431);
		City city6 = new City("Orlando", 28.5383, -81.3792);

		cities.add(city1);
		cities.add(city2);
		cities.add(city3);
		cities.add(city4);
		cities.add(city5);
		cities.add(city6);

		String startCity;
		String endCity;
		
		City  [] selectedCities = cityChoices(cities);
		
		
		

		if (selectedCities[0] != null && selectedCities[1] != null) {
            DirectionEnum direction = getDirection(selectedCities[0], selectedCities[1]);
            System.out.println("Direction from " + selectedCities[0].name + " to " + selectedCities[1].name + " is " + direction);
        } else {
            System.out.println("One or both of the cities were not found.");
        }


	}

	private static DirectionEnum getDirection(City start, City end) {
		double latDiff = end.latitude - start.latitude;
		double lonDiff = end.longitude - start.longitude;

		if (latDiff > 0 && lonDiff > 0) {
			return DirectionEnum.NORTHEAST;
		} else if (latDiff > 0 && lonDiff < 0) {
			return DirectionEnum.NORTHWEST;
		} else if (latDiff < 0 && lonDiff > 0) {
			return DirectionEnum.SOUTHEAST;
		} else if (latDiff < 0 && lonDiff < 0) {
			return DirectionEnum.SOUTHWEST;
		} else if (latDiff > 0) {
			return DirectionEnum.NORTH;
		} else if (latDiff < 0) {
			return DirectionEnum.SOUTH;
		} else if (lonDiff > 0) {
			return DirectionEnum.EAST;
		} else {
			return DirectionEnum.WEST;
		}
	}

	public static City[] cityChoices(ArrayList<City> cities) {

		Scanner input = new Scanner(System.in);
		System.out.println("Which city is closest to yout start point");

		for (City city : cities) {

			System.out.println(city.name);

		}

		String userStartCity = input.nextLine();
		City startCity = null;
		for (City city : cities) {
			if (city.name.equalsIgnoreCase(userStartCity)) {

				startCity = city;

			}
		}

		System.out.println("Enter the city closest to your destination");

		for (City city : cities) {

			System.out.println(city.name);
		}

		String userEndCity = input.nextLine();

		City endCity = null;
		for (City city : cities) {
			if (city.name.equalsIgnoreCase(userEndCity)) {

				endCity = city;

			}
		}
		
		return new City [] {startCity, endCity};

	}

}
