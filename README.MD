# Connection Pool bug

This shows that if `connection.close()` is not called within the transaction timeout, the connection pool leaks and the app eventually becomes unsuable.


To Demo:
```
mvn clean package tomee:run
```

Then, run this 4 times:
```
http://localhost:8080/tomee-jms2-bug/api/1.0
```

