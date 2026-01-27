import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

public class Tester {
    public static void main(String[] args) {
        System.out.println("=== НАЧИНАЕМ ТЕСТИРОВАНИЕ API ===");

        try {
            HttpClient client = HttpClient.newHttpClient();

            // POST
            System.out.println("\n1. Отправляем запрос POST (Создать пользователя 'JavaMaster')...");
            String jsonNewUser = "{\"username\":\"JavaMaster\",\"followersCount\":500}";

            HttpRequest requestPost = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:7000/profiles"))
                    .header("Content-Type", "application/json")
                    .POST(BodyPublishers.ofString(jsonNewUser))
                    .build();

            HttpResponse<String> responsePost = client.send(requestPost, BodyHandlers.ofString());
            System.out.println("Ответ сервера: " + responsePost.body());


            // PUT
            System.out.println("\n2. Отправляем запрос PUT (Изменить подписчиков на 9999)...");
            String jsonUpdate = "{\"followersCount\":9999}";

            HttpRequest requestPut = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:7000/profiles/JavaMaster"))
                    .header("Content-Type", "application/json")
                    .PUT(BodyPublishers.ofString(jsonUpdate))
                    .build();

            HttpResponse<String> responsePut = client.send(requestPut, BodyHandlers.ofString());
            System.out.println("Ответ сервера: " + responsePut.body());


            // GET
            // (Чтобы убедиться, что подписчики реально изменились в базе)
            System.out.println("\n3. Проверяем, что в базе (GET)...");
            HttpRequest requestGet = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:7000/profiles"))
                    .GET()
                    .build();
            HttpResponse<String> responseGet = client.send(requestGet, BodyHandlers.ofString());
            System.out.println("Список из базы: " + responseGet.body());


            // DELETE
            System.out.println("\n4. Отправляем запрос DELETE (Удалить 'JavaMaster')...");

            HttpRequest requestDelete = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:7000/profiles/JavaMaster"))
                    .DELETE()
                    .build();

            HttpResponse<String> responseDelete = client.send(requestDelete, BodyHandlers.ofString());
            System.out.println("Ответ сервера: " + responseDelete.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}