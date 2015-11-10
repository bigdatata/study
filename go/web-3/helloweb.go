package main

import (
	"fmt"
	"net/http"
	"strings"
	"log"
)

func sayHelloName(w http.ResponseWriter,r *http.Request){
	r.ParseForm() //解析参数，默认是不会解析的
	fmt.Println(r.Form)
	fmt.Println("path",r.URL.Path)
	fmt.Println("scheme",r.URL.Scheme)
	fmt.Println(r.Form["url_long"])
	for k,v :=range r.Form{
		fmt.Println("key:",k)
		fmt.Println("val:",strings.Join(v,""))
	}
	fmt.Fprintf(w,"Hello astaxie!")
}

type MyMux struct{
	
}

func (p *MyMux) ServeHTTP(w http.ResponseWriter,r *http.Request){
	if r.URL.Path == "/"{
		sayHelloName(w,r)
		return
	}
	http.NotFound(w,r)
	return
}

func main(){
//	http.HandleFunc("/",sayHelloName)//设置访问的路由
	mux := &MyMux{}
	err := http.ListenAndServe(":9090",mux)
//	err := http.ListenAndServe(":9090",nil)//设置监听的端口
	if err !=nil{
		log.Fatal("ListenAndServe: ",err)
	}
}