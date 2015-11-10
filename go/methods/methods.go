package main

import (
	"fmt"
	"math"
)

//Go does not have classes. However, you can define methods on struct types.
//The method receiver appears in its own argument list between the func keyword and the method name.
type Vertex struct{
	X,Y float64
}

func (v *Vertex) Abs() float64{
	return math.Sqrt(v.X*v.X+v.Y*v.Y)
}
//You can declare a method on any type that is declared in your package, not just struct types.
//However, you cannot define a method on a type from another package (including built in types)
type MyFloat float64
func (f MyFloat) Abs() float64 {
	if f < 0 {
		return float64(-f)
	}
	return float64(f)
}
//There are two reasons to use a pointer receiver.  like Abs()
//First, to avoid copying the value on each method call (more efficient if the value type is a large struct). 
//Second, so that the method can modify the value that its receiver points to.
type Abser interface {
	Abs() float64
}

type Person struct {
	Name string
	Age  int
}

type Stringer interface {
    String() string
}

func (p Person) String() string {
	return fmt.Sprintf("%v (%v years)", p.Name, p.Age)
}

type IPAddr [4]byte

func (ip IPAddr) String() string{
	return fmt.Sprintf("%v.%v.%v.%v",ip[0],ip[1],ip[2],ip[3])
}
func main(){
	v := Vertex{3,4}
	fmt.Println(v.Abs())
	fmt.Println(MyFloat(-12.12).Abs())
	var a Abser;
	f := MyFloat(-math.Sqrt2)
	a = f  // a MyFloat implements Abser
	fmt.Println(a.Abs())
	a = &v // a *Vertex implements Abser
	fmt.Println(a.Abs())
	// In the following line, v is a Vertex (not *Vertex)
	// and does NOT implement Abser.
//	a = v
	
	fmt.Println(Person{"hello world",28})

	fmt.Println(IPAddr{1, 2, 3, 4})
}