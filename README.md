- Projede initial db ve veriler resource klosörü altında eklendi.
- Projede oluşturulan tablolara ait service, repository ve controller katmanları oluşturulsa da sadece Student ve StudentTest tabloları için geliştirme yapıldı. Diğer tablolar CRUD olacağı için onları eklemedim.
- Uygulamanın şu an fonksiyonu bir öğrencinin testlerini görebilmesi ve testlere ait doğru yanlış sayılarını görebilmesi, ayrıca da yeni bir test ekleyebilmesi şeklindedir.
- Uygulamanın endpointlerine swagger ile http://localhost:8080/swagger-ui/index.html 'den ulaşılabilir.
- Uygulamada basit spring'e ait olan cache kullanılmıştır.
- Uygulamada sadece service katmanları için unit testler yazılmıştır.
- Uygulamada ayrıca genel exception yönetimi yapılmıştır.
- Responseların belirli bir yapı da dönülmesi için genel response yapısı uygulanmıştır.
