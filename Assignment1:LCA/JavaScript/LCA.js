// Node class 
class Node 
{ 
    constructor(data) 
    { 
        this.data = data; 
        this.left = null; 
        this.right = null; 
        this.prev = null;
    } 
}

export class BinarySearchTree 
{ 
    constructor() 
    { 
        // root of a binary seach tree 
        this.root = null; 
    } 
  
    // function to be implemented 
    // insert(data) 
    // remove(data) 
                  
  
    // Helper function 
    // findMinNode() 
    // getRootNode() 
    // inorder(node) 
    // preorder(node)                
    // postorder(node) 
    // search(node, data) 

    // helper method which creates a new node to 
    // be inserted and calls insertNode 
    insert(data) {
        // Creating a node and initailising 
        // with data 
        var newNode = new Node(data);

        // root is null then node will 
        // be added to the tree and made root. 
        if (this.root === null)
            this.root = newNode;
        else

            // find the correct position in the 
            // tree and add the node 
            this.insertNode(this.root, newNode);
    }

    // Method to insert a node in a tree 
    // it moves over the tree to find the location 
    // to insert a node with a given data 
    insertNode(node, newNode) {
        // if the data is less than the node 
        // data move left of the tree 
        
        console.log("node.data: "+node.data);
        if((node.prev) != null) console.log("node.prev: "+(node.prev).data);

        if (newNode.data < node.data) {
            // if left is null insert node here 
            if (node.left === null){
                node.left = newNode;
                (node.left).prev = node;
            }
            else

                // if left is not null recur until 
                // null is found 
                this.insertNode(node.left, newNode);
        }

        // if the data is more than the node 
        // data move right of the tree 
        else {
            // if right is null insert node here 
            if (node.right === null){
                node.right = newNode;
                (node.right).prev = node;
            }
            else

                // if right is not null recur until 
                // null is found 
                this.insertNode(node.right, newNode);
        }
    } 

    // helper method that calls the 
    // removeNode with a given data 
    remove(data) {
        // root is re-initialized with 
        // root of a modified tree. 
        this.root = this.removeNode(this.root, data);
    }

    // Method to remove node with a 
    // given data 
    // it recur over the tree to find the 
    // data and removes it 
    removeNode(node, key) {

        // if the root is null then tree is 
        // empty 
        if (node === null)
            return null;

        // if data to be delete is less than 
        // roots data then move to left subtree 
        else if (key < node.data) {
            node.left = this.removeNode(node.left, key);
            return node;
        }

        // if data to be delete is greater than 
        // roots data then move to right subtree 
        else if (key > node.data) {
            node.right = this.removeNode(node.right, key);
            return node;
        }

        // if data is similar to the root's data 
        // then delete this node 
        else {
            // deleting node with no children 
            if (node.left === null && node.right === null) {
                node = null;
                return node;
            }

            // deleting node with one children 
            if (node.left === null) {
                node = node.right;
                return node;
            }

            else if (node.right === null) {
                node = node.left;
                return node;
            }

            // Deleting node with two children 
            // minumum node of the rigt subtree 
            // is stored in aux 
            var aux = this.findMinNode(node.right);
            node.data = aux.data;

            node.right = this.removeNode(node.right, aux.data);
            return node;
        }

    } 

    // Performs inorder traversal of a tree 
    inorder(node) {
        if (node !== null) {
            this.inorder(node.left);
            console.log(node.data);
            this.inorder(node.right);
        }
    } 

    // Performs preorder traversal of a tree     
    preorder(node) {
        if (node !== null) {
            console.log(node.data);
            this.preorder(node.left);
            this.preorder(node.right);
        }
    } 

    // Performs postorder traversal of a tree 
    postorder(node) {
        if (node !== null) {
            this.postorder(node.left);
            this.postorder(node.right);
            console.log(node.data);
        }
    } 

    // finds the minimum node in tree 
    // searching starts from given node 
    findMinNode(node) {
        // if left of a node is null 
        // then it must be minimum node 
        if (node.left === null)
            return node;
        else
            return this.findMinNode(node.left);
    } 

    // returns root of the tree 
    getRootNode() {
        return this.root;
    } 

    // search for a node with given data 
    search(node, data) {
        // if trees is empty return null 
        if (node === null)
            return null;

        // if data is less than node's data 
        // move left 
        else if (data < node.data)
            return this.search(node.left, data);

        // if data is less than node's data 
        // move left 
        else if (data > node.data)
            return this.search(node.right, data);

        // if data is equal to the node data  
        // return node 
        else
            return node;
    } 


    // I created createParentList() and findLCA() : line 223~278
    createParentList(node){
        var list = [];
        var currentNode = node;
        if(currentNode.prev == null){ // if node = root
            list.push(currentNode);
            return list;
        }

        while(currentNode.prev!=null){ // if node != root
            list.push(currentNode);
            var prevNode = currentNode.prev;
            currentNode = prevNode;
        }
        list.push(currentNode);
        return list;
    }

    findLCA(data1, data2){
        var node1 = this.search(this.root, data1);
        var node2 = this.search(this.root, data2);

        // if there is no node matched with give data, return null
        if(node1==null) return null;
        if(node2==null) return null;

        var node1s = this.createParentList(node1);
        var node2s = this.createParentList(node2);
        
        var tmp1 = node1s[1];
        // console.log("node1s[0].data: "+node1s[0].data);
        // console.log("node2s[0].data: "+node2s[0].data);
        // console.log("node1s[1].data: "+tmp1.data);
        // console.log("node2s[1].data: "+node2s[1].data);
        // console.log("node1s[2].data: "+node1s[2].data);
        // console.log("node2s[2].data: "+node2s[2].data);


        var result = null;
        if(node1s.length<node2.length){
            for(var i=0; i<node1s.length && result==null;i++) {
				for(var j=0;j<node2s.length && result==null;j++) {
					if(node1s[i].data == node2s[j].data) result = node1s[i];
				}
			}
        }
        else{ //node2s.length<=node2.length
            for(var i=0; i<node2s.length && result==null;i++) {
				for(var j=0;j<node1s.length && result==null;j++) {
                    // console.log("node2s["+i+"].data: "+node2s[i].data);
                    // console.log("node1s["+j+"].data: "+node1s[j].data)
					if(node2s[i].data == node1s[j].data) result = node2s[i];
				}
			}
        }
        return result;
    }

} 


// // create an object for the BinarySearchTree 
// var BST = new BinarySearchTree(); 
  
// // Inserting nodes to the BinarySearchTree 
// BST.insert(15); 
// BST.insert(25); 
// BST.insert(10); 
// BST.insert(7); 
// BST.insert(22); 
// BST.insert(17); 
// BST.insert(13); 
// BST.insert(5); 
// BST.insert(9); 
// BST.insert(27); 
                          
// //          15 
// //         /  \ 
// //        10   25 
// //       / \   / \ 
// //      7  13 22  27 
// //     / \    / 
// //    5   9  17  
  
// var root = BST.getRootNode(); 
              
// // prints 5 7 9 10 13 15 17 22 25 27 
// BST.inorder(root); 
              
// // console.log("postorder traversal"); 
// // BST.postorder(root); 
// // console.log("preorder traversal"); 
// // BST.preorder(root); 

// var result = BST.findLCA(5,9);
// console.log("BST.findLCA(5,9): "+result.data);

// result = BST.findLCA(13,22);
// console.log("BST.findLCA(13,22): "+result.data);
// result = BST.findLCA(7,9);
// console.log("BST.findLCA(7,9): "+result.data);
