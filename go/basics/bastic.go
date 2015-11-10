package main

import (
	"fmt"
	"math/cmplx"
)

func add(x int,y int) int{
	return x+y
}
func swap(x,y string)(string,string){
	return y,x
}

func split(sum int)(x,y int){
	x=sum*4/9
	y=sum-x
	return
}

var c,python,java bool
var (
	ToBe   bool       = false
	MaxInt uint64     = 1<<64 - 1
	z      complex128 = cmplx.Sqrt(-5 + 12i)
)
const Pi = 3.14

const (
	Big   = 1 << 100
	Small = Big >> 99
)

func needInt(x int) int { return x*10 + 1 }
func needFloat(x float64) float64 {
	return x * 0.1
}

func main(){
	fmt.Println(add(2,4))
	a,b:=swap("hello","world")
	fmt.Println(a,b)
	fmt.Println(split(134))
	var i int
	fmt.Println(i,c,python,java)
	const f = "%T(%v)\n"
	fmt.Printf(f, ToBe, ToBe)
	fmt.Printf(f, MaxInt, MaxInt)
	fmt.Printf(f, z, z)
	
	const World = "世界"
	fmt.Println("Hello", World)
	fmt.Println("Happy", Pi, "Day")

	const Truth = true
	fmt.Println("Go rules?", Truth)
	
	fmt.Println(needInt(Small))
	fmt.Println(needFloat(Small))
	fmt.Println(needFloat(Big))
}