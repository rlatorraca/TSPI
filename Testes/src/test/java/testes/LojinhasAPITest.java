package testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

public class LojinhasAPITest {

    @Test
    public void testBuscaDadosDeUmProdutoEspecifico() {
        RestAssured.baseURI = "http://165.227.93.41"; // endereco do servidor
        RestAssured.basePath = "lojinha"; // path da APi

        //Pegar o token para acessar a API
        String token = RestAssured
                            .given()
                                .contentType(ContentType.JSON)
                                .body("{ \"usuariologin\":\"admin\", \"usuariosenha\": \"admin\"}")
                            .when()
                                .post("login")
                            .then()
                                .extract()
                                    .path("data.token");

        System.out.println("TOKEN : " + token);

        RestAssured
                .given()
                    .header("token", token)
                .when()
                    .get("produto/70")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.produtonome", Matchers.equalTo("PS4"))
                        .body("data.componentes[0].componentenome", Matchers.equalTo("Controle"))
                        .body("message", Matchers.equalTo("Detalhando dados do produto"));
    }
}
