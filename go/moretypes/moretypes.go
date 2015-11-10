package main

import (
	"fmt"
	"strings"
	"math"
)
import "golang.org/x/tour/pic"
import "golang.org/x/tour/wc"

func point(){
	i,j := 42,2701
	p := &i         // point to i
	fmt.Println(*p) // read i through the pointer
	*p = 21         // set i through the pointer
	fmt.Println(i)  // see the new value of i

	p = &j         // point to j
	*p = *p / 37   // divide j through the pointer
	fmt.Println(j) // see the new value of j
}

type Vertex struct{
	X int
	Y int
}

func arrays(){
	var a[2]string
	a[0]="hello"
	a[1] = "world"
	fmt.Println(a)
	
}

func slices(){
	p := []int{2, 3, 5, 7, 11, 13}
	fmt.Println("p ==", p)

	for i := 0; i < len(p); i++ {
		fmt.Printf("p[%d] == %d\n", i, p[i])
	}
	fmt.Println("p[1:4] ==", p[1:4])

	// missing low index implies 0
	fmt.Println("p[:3] ==", p[:3])

	// missing high index implies len(s)
	fmt.Println("p[4:] ==", p[4:])
	
	b := make([]int, 0, 5)
	fmt.Printf("len=%d cap=%d %v\n",len(b), cap(b), b)
	
	var a []int
	printSlice("a", a)
	// we can add more than one element at a time.
	a = append(a, 2, 3, 4)
	printSlice("a", a)
	
}

func printSlice(s string, x []int) {
	fmt.Printf("%s len=%d cap=%d %v\n",
		s, len(x), cap(x), x)
}
/*
The range form of the for loop iterates over a slice or map.
*/
func ranges(){
	pow := make([]int, 10)
	for i := range pow {
		pow[i] = 1 << uint(i)
	}
	for _, value := range pow {
		fmt.Printf("%d\n", value)
	}
	for i, v := range pow {
		fmt.Printf("2**%d = %d\n", i, v)
	}
}

func Pic(dx, dy int) [][]uint8 {
	var pic[][] uint8
	for i:=0;i<dx;i++{
		var picX[] uint8
		for j:=0;j<dy;j++{
			picX = append(picX,uint8(1))
		}
		pic  = append(pic,picX)
	}
	return pic;
}

type VertexLong struct{
	Lat,Long float64
}
/*
Maps must be created with make (not new) before use; the nil map is empty and cannot be assigned to.
*/
func mapTest(){
	var m map[string]VertexLong
	m=make(map[string]VertexLong)
	m["Bell Labs"] = VertexLong{40.68433,-70.39967,}
	fmt.Println(m["Bell Labs"])
	var m2 = map[string]VertexLong{
	"Bell Labs": VertexLong{
		40.68433, -74.39967,
	},
	"Google": VertexLong{
		37.42202, -122.08408,
	},
	}
	fmt.Println(m2)
	//If the top-level type is just a type name, you can omit it from the elements of the literal.
	var m3 = map[string]VertexLong{
	"Bell Labs": {40.68433, -74.39967},
	"Google":    {37.42202, -122.08408},
	}
	fmt.Println(m3)
}

func MutatingMaps(){
	m := make(map[string]int)

	m["Answer"] = 42
	fmt.Println("The value:", m["Answer"])

	m["Answer"] = 48
	fmt.Println("The value:", m["Answer"])

	delete(m, "Answer")
	fmt.Println("The value:", m["Answer"])

	v, ok := m["Answer"]
	fmt.Println("The value:", v, "Present?", ok)
}



func FunctionValues(){
	hypot := func(x, y float64) float64 {
		return math.Sqrt(x*x + y*y)
	}
	fmt.Println(hypot(3, 4))
}

func WordCount(s string) map[string]int {
	m:=make(map[string]int)
	var stringArray=strings.Fields(s)
	for i := 0; i < len(stringArray); i++ {
		var v=m[stringArray[i]]
		m[stringArray[i]] =v+1
	}
	return m 
}
func adder() func(int) int {
	sum := 0
	return func(x int) int {
		sum += x
		return sum
	}
}
func FunctionClosures(){
	pos,neg :=adder(),adder()
	for i:=0;i<10;i++{
		fmt.Println(pos(i),neg(-2*i))
	}
}
// fibonacci is a function that returns
// a function that returns an int.
// 1,1,2,3,5,8
func fibonacci() func() int {
	first,second:=0,1
	return func() int{
		first,second =second,first + second
		return first;
	}
}

func main(){
	point();
	fmt.Println(Vertex{1,3})
	v := Vertex{1,2}
	v.X = 4
	fmt.Println(v.X)
	// pointers to structs
	v = Vertex{1,2}
	p :=&v
	p.X=1e4
	fmt.Println(v)
	arrays();
	slices();
	ranges();
	pic.Show(Pic)
	mapTest()
	MutatingMaps()
	wc.Test(WordCount)
	FunctionValues()
	FunctionClosures()
	f := fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Println(f())
	}
}