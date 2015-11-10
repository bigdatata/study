package main

import (
	"fmt"
	"time"
	"golang.org/x/tour/tree"
)

func say(s string) {
	for i := 0; i < 5; i++ {
		time.Sleep(100 * time.Millisecond)
		fmt.Println(s)
	}
}

func sum(a []int, c chan int) {
	sum := 0
	for _, v := range a {
		sum += v
	}
	c <- sum // send sum to c
}
//Sends to a buffered channel block only when the buffer is full. Receives block when the buffer is empty.
func BufferedChannels(){
	c := make(chan int, 2)
	c <- 1
	c <- 2
	fmt.Println(<-c)
	fmt.Println(<-c)
}
func fibonacci1(n int, c chan int) {
	x, y := 0, 1
	for i := 0; i < n; i++ {
		c <- x
		x, y = y, x+y
	}
	close(c)
}
func RangeClose(){
	c := make(chan int,10)
	go fibonacci1(cap(c),c)
	for i :=range c{
		fmt.Println(i)
	}
}

func fibonacci(c, quit chan int) {
	x, y := 0, 1
	for {
		select {
		case c <- x:
			x, y = y, x+y
		case <-quit:
			fmt.Println("quit")
			return
		}
	}
}

func selectChannel(){
	c := make(chan int)
	quit := make(chan int)
	go func() {
		for i := 0; i < 10; i++ {
			fmt.Println(<-c)
		}
		quit <- 0
	}()
	fibonacci(c, quit)
}

func DefaultSelection(){
	tick := time.Tick(100 * time.Millisecond)
	boom := time.After(500 * time.Millisecond)
	for {
		select {
		case <-tick:
			fmt.Println("tick.")
		case <-boom:
			fmt.Println("BOOM!")
			return
		default:
			fmt.Println("    .")
			time.Sleep(50 * time.Millisecond)
		}
	}
}

// Walk walks the tree t sending all values
// from the tree to the channel ch.
func Walk(t *tree.Tree, ch chan int){
	if t == nil{
		return
	}
	ch<-t.Value
	Walk(t.Left,ch)
	Walk(t.Right,ch)
}

// Same determines whether the trees
// t1 and t2 contain the same values.
func Same(t1, t2 *tree.Tree) bool{
	channel1 := make(chan int)
	channel2 := make(chan int)
	go func(){
		Walk(t1,channel1)
		channel1<-0
	}()
	go func(){
		Walk(t2,channel2)
		channel2<-0
	}()
	for {
        t1 := <-channel1
        t2 := <-channel2
        if t1 == 0 && t2 == 0 {
             return true;
        }
       
        if t1 == t2 {
             continue;
        } else {
             return false;
        }
   	}
	   return true
	
}

func main() {
//	go say("world")
//	say("hello")
	a := []int{7, 2, 8, -9, 4, 0}

	c := make(chan int)
	go sum(a[:len(a)/2], c)
	go sum(a[len(a)/2:], c)
	x, y := <-c, <-c // receive from c

	fmt.Println(x, y, x+y)
	BufferedChannels()
	RangeClose()
	selectChannel()
	DefaultSelection()
	fmt.Println(Same(tree.New(1), tree.New(1)))
}