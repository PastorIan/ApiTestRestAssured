
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.*;


public class Test1 {

    //Prueba para iniciar sesion
    @Test
    void Test1(){
        given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1").then().log()
                .all();

    }

    //Prueba para iniciar sesion utilizando queryParam, retornando los datos del usuario en html
    @Test
    void Test2(){

        given().queryParam("PASSWORD","1234!")
                .queryParam("CUSTOMER_ID","68195")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();
    }

    //Prueba para response status 200
    //getStatusCode para obtener el valor del código de estado
    //assertThat (). StatusCode(200) para comparar
    @Test
    void Test3(){
        int statusCode= given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        given().when().get("http://demo.guru99.com/V4/sinkministatement.php").then().assertThat().statusCode(200);
    }

    //Prueba para obtener el tipo de contenido de la respuesta
    //"contentType"
    @Test
    void Test4(){
        System.out.println("The content type of response "+
                get("http://demo.guru99.com/V4/sinkministatement.php").then().extract()
                        .contentType());
    }
    //Prueba para obtener el tiempo de respuesta
    //Rest Assured proporciona un método llamado 'timeIn'
    // con un timeUnit adecuado para obtener el tiempo necesario para devolver la respuesta.
    @Test
    void Test5(){
        System.out.println("The time taken to fetch the response "+get("http://demo.guru99.com/V4/sinkministatement.php")
                .timeIn(TimeUnit.SECONDS) + " seconds");
    }

}
