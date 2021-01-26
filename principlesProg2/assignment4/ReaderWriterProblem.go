package main

import (
	"fmt"
  "strconv"
  "sync"
)

// The Resource we are accessing with multiple threads
var Balance = &currency{amount: 50.00, code: "GBP"}

// currency struct
// Must be synced with the mutex
type currency struct {
  sync.RWMutex
  amount float64
  code   string
}

// Adds currency to the balance
// Lock is used to lock the writer
func (c *currency) Add(i float64) {
  c.Lock()
  c.amount += i
  c.Unlock()
}

// Displays the balance
// RLock is used to lock the reader
func (c *currency) Display() string {
  c.RLock()
  defer c.RUnlock()
  return strconv.FormatFloat(c.amount, 'f', 2, 64) + " " + c.code
}

// main
func main() {
	// Creates 10 threads that add 1.20 to the balance
	for i := 0; i < 10; i++ {
		go Balance.Add(1.20)
	}

	// Display the balance
	for i := 0; i < 10; i++ {
		var str = Balance.Display()
		fmt.Println(str)
	}

	// So the threads have time to finish
	var input string
	fmt.Scanln(&input)
}

/* Output
58.40 GBP
62.00 GBP
62.00 GBP
62.00 GBP
62.00 GBP
62.00 GBP
62.00 GBP
62.00 GBP
62.00 GBP
62.00 GBP
*/
