# todo-tool

This is tools of todo app of cosujure.

## client
```
lein run
```

## mock
```
cd wiremock
docker build -t todo-clojure .
docker run -it --rm -p 3000:8080 todo-clojure
```