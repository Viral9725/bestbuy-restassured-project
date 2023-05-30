package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    @Test
    public void test001ExtractTheValueOfLimit() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test002ExtractTheTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    /*    3. Extract the name of 5th store     */
    @Test
    public void test003ExtractTheNameof5thStore() {
        String storeName = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store: " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    /*    4. Extract the names of all the store     */
    @Test
    public void test004ExtractNameOfAllStore() {
        List<Integer> allStoreName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }

    /* 5. Extract the storeId of all the store */
    @Test
    public void test004ExtractTheStoreIdOfAllStore() {
        List<Integer> allStoreName = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store id is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }

    /* 6. Print the size of the data list */
    @Test
    public void printSizeOfDataList() {
        List<Integer> dataList = response.extract().path("data");
        dataList.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    /*7. Get all the value of the store where store name = St Cloud */
    @Test
    public void printSizeOfStoreNameStCloud() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("print Size Of Store NameStCloud: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    // 8. Get the address of the store where store name = Rochester
    @Test
    public void printStoreNameRochester() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Rochester'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Print the Store Name Rochester : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void printStoreListData() {
        List<?> storeListData = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + storeListData);
        System.out.println("------------------End of Test---------------------------");
    }

    // 10. Get storeservices of the store where service name = Windows Store
    @Test
    public void getExactWindowsStore() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Windows Store'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for product name 'Windows Store' are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void getExactStoreIdOfAllTheStore() {
        List<Integer> listOfStoredID = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Get all the storeId of all the store: " + listOfStoredID);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void getIDOFStoreId() {
        List<Integer> listOfStoredID = response.extract().path("data.services.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Get all the storeId of all the store: " + listOfStoredID);
        System.out.println("------------------End of Test---------------------------");
    }

    //13. Find the store names Where state = ND
    @Test
    public void storeNamesStartWithStateND() {
        List<?> menuList = response.extract().path("data.findAll{it.state.startsWith('ND')}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store Names Start With State = ND  are: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void printTotalNumberOfServicesStoreNameRochester() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Rochester'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Print the total Number of Store Name Rochester : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void getExactAllServicesWithWindowsStore() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.services.name == 'Windows Store'}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The getExact All Services With 'Windows Store' are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void storeNamesStartWithFargo() {
        List<?> menuList = response.extract().path("data.findAll{it.name.startsWith('Fargo')}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store Names Start = Fargo  are: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void zipOfAllTheStore() {
        List<?> menuList = response.extract().path("data.findAll{it.zip}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip Of All The Store are: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void zipOfStoreNameRoseville() {
        List<?> menuList = response.extract().path("data.findAll{it.name.startsWith('Roseville')}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of store name = Roseville Are: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void storeServicesDetailsOfTheServiceNameMagnoliaHomeTheater() {
        List<?> menuList = response.extract().path("data.findAll{it.name.startsWith('Magnolia Home Theater')}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store Services Details Of The Service Name = MagnoliaHomeTheater: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void latOfAllTheStore() {
        List<?> menuList = response.extract().path("data.findAll{it.lat}.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat Of All The Store are: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }
}
