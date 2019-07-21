package main

import (
    . "github.com/iotaledger/iota.go/api"
    "fmt"
    "os"
)

func main() {
	endpoint := os.Args[1]

	// compose a new API instance
	api, err := ComposeAPI(HTTPClientSettings{URI: endpoint})
	must(err)

	nodeInfo, err := api.GetNodeInfo()
	must(err)

	fmt.Println("latest milestone index:", nodeInfo.LatestMilestoneIndex)
}

func must(err error) {
	if err != nil {
		panic(err)
	}
}
