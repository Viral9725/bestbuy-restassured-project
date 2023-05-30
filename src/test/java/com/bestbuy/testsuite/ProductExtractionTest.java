package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    @Before
    public void setUp() {
        RestAssured.basePath = "/products";
    }

    //21. Extract the limit
    @Test
    public void test021ExtractTheValueOfLimit() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //22. Extract the total
    @Test
    public void test022ExtractTheTotal() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //23. Extract the name of 5th product
    @Test
    public void test023ExtractTheNameof5thStore() {
        String productName = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th productName: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void test004ExtractNameOfAllProducts() {
        List<Integer> allProductsName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All Products Name is : " + allProductsName);
        System.out.println("------------------End of Test---------------------------");
    }

    //25. Extract the productId of all the products
    @Test
    public void test025ExtractTheStoreIdOfAllStore() {
        List<Integer> allStoreName = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of the All store id is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }

    //26. Print the size of the data list
    @Test
    public void test026printSizeOfDataList() {
        List<Integer> dataList = response.extract().path("data");
        dataList.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data is : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027printProductOfEnergizerMAXBatteriesAA() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("print Product Of Energizer MAXBatteries AA: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028printProductNameEnergizerNCellE90Batteries() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Print the Product Name Energizer NCell E90Batteries : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void test029printCategoriesOf8ListData() {
        List<?> storeListData = response.extract().path("data[8].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The print Categories Of 8 ListData : " + storeListData);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test030GetCategoriesOfTheStoreWhereProductId150115() {
        List<Integer> categories = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The first product name is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void getExactAllDescriptionsOfProducts() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.description}.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Get ExactAll Descriptions Of  Products are: " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void getIDOfProductOfAllCategories() {
        List<?> menuList = response.extract().path("data.findAll{it.id}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("get ID Of Product Of All Categories are: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }
    //33. Find the product names Where type = HardGood
    @Test
    public void printProductNameOfTypeOfHardGood() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("print Product Name is Type Of HardGood : " + values);
        System.out.println("------------------End of Test---------------------------");
    }
    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void printTotalNumberOfCategoriesForProductStoreDuracellAA() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.categories == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Print Total Number Of Categories For Product Store 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)': " + values);
        System.out.println("------------------End of Test---------------------------");   }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test009CreatedAtForAllProducts () {
        List<String> productNames = response.extract().path("data.findAll{it.price < 5.49}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Created At For All Products are: " + productNames);
        System.out.println("------------------End of Test---------------------------"); }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void allCategoriesProductNameEnergizerMAXBatteriesAA2() {
        List<?> menuList = response.extract().path("data.findAll{it.name.startsWith('Energizer - MAX Batteries AA (4-Pack)')}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Show all categories Where product name = 'Energizer - MAX Batteries AA (4-Pack):'" + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void manufacturerOfAllTheProducts() {
        List<?> menuList = response.extract().path("data.findAll{it.manufacturer}.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer of all the products are: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void manufacturerOfAllTheProductsIsEnergizer() {

        List<?> menuList = response.extract().path("data.findAll{it.manufacturer.startsWith('Energizer')}.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer of all the products are Energizer List: " + menuList);
        System.out.println("------------------End of Test---------------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039CreatedAtForAllProducts () {
        List<String> productNames = response.extract().path("data.findAll{it.price > 5.49}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Created At For All Products where price > 5.99 are: " + productNames);
        System.out.println("------------------End of Test---------------------------"); }

    //40. Find the url of all the products
    @Test
    public void test040FindTheURLOfAllTheProducts() {
        //    String url = response.extract().path("data.url");
        List<HashMap<String, ?>> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The URL of all the products: " + url);
        System.out.println("------------------End of Test---------------------------");
    }


}

