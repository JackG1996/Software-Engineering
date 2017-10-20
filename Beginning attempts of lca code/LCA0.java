 class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class GfG
{   
    Node lca(Node node, int n1, int n2) 
    {
        if(node.data < n1 && node.data < n2)
        {
            node.data = node.data.right;
            node = node.right;
            lca(node,n1,n2);
        }
        else if(node.data > n1 && node.data > n2)
        {
            node.data = node.data.left;
            node = node.left;
            lca(node,n1,n2);
        }
        else
        {
            return node.data;
        }
        
    }
    
}