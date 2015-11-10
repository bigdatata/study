package main

import "fmt"
import "math"
import "runtime"


func pow(x,n,lim float64) float64{
	if v:=math.Pow(x,n);v<lim{
		return v
	}
	return lim
}

func Sqrt(x float64) float64 {
	z:=1.0
	for i:=0;i<10;i++{
		z=z-(z*z-x)/2/z
	}
	return z
}

func main(){
	sum:=0
	for i:=0;i<10;i++{
		sum+=i
	}
	fmt.Println(sum)
	sum=1
	for ;sum<1000;{
		sum+=sum;
	}
	fmt.Println(sum)
	//go's while
	sum = 1
	for sum < 1000 {
		sum += sum
	}
	fmt.Println(sum)
	//if with a short statement
	fmt.Println(pow(2,3,10),pow(3,3,20))
	
	fmt.Println(Sqrt(2))
	
	fmt.Print("Go runs on ")
	
	switch os:=runtime.GOOS;os{
		case "darwin":
			fmt.Println("OS X.")
		case "linux":
			fmt.Println("Linux.")
		case "windows":
			fmt.Println("windows.")
		default:
			// freebsd, openbsd,
			// plan9, windows...
			fmt.Println(os)
	}
	
	defer fmt.Println("world")

	fmt.Println("hello")
	
	fmt.Println("counting")

	for i := 0; i < 10; i++ {
		defer fmt.Println(i)
	}

	fmt.Println("done")
}