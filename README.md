# Use this Project to calculate routes for your requirement

Current support is an api which takes cordinates for driver, multiple resturants and multiple customers, speed and returns the best possible route and min possible time.

Invoke POST API /getBestRoute

Sample input JSON

{
  "driverCordinates": {
    "latitude": 10.99,
    "longitude": 10.97
  },
  "restaurantCordinates": [
    {
      "latitude": 11,
      "longitude": 11
    },
    {
      "latitude": 11.01,
      "longitude": 11.03
    }
  ],
  "customerCordinates": [
    {
      "latitude": 11.06,
      "longitude": 11.07
    },
    {
      "latitude": 11.22,
      "longitude": 11.28
    }
  ],
  "cookingTimePerResturant": [
    0.3,
    0.5
  ],
  "driverSpeed": 20
}



Sample Output JSON

{
    "bestRoute": [
        "R1",
        "R2",
        "C1",
        "C2"
    ],
    "minPossibleTime": 2.3038208316426987
}


All distances are in KMs, all time units are in hrs

Stay tuned for further updates.
