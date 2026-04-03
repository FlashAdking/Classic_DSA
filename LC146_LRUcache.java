class ListNode{
    int key;
    int val;
    ListNode prev;
    ListNode next;

    ListNode(){}

    ListNode(int key ,int val , ListNode prev , ListNode next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}



class LRUCache {

    Map<Integer , ListNode> map;
    int capacity;
    int counter = 0;
    ListNode dummy_head;
    ListNode dummy_tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        dummy_head = new ListNode();
        dummy_tail = new ListNode();

        dummy_head.prev = null;
        dummy_head.next = dummy_tail;
        
        dummy_tail.prev = dummy_head;
        dummy_tail.next = null;

    }
    
    public int get(int key) {
        if( map.containsKey(key)){
            ListNode node = map.get(key);

            if(dummy_tail.prev == node){
                return node.val;
            }


            ListNode prev = node.prev;
            ListNode next = node.next;

            prev.next = next;
            next.prev = prev;

            ListNode prev_tail = dummy_tail.prev;

            prev_tail.next = node;
            node.prev = prev_tail;

            node.next = dummy_tail;
            dummy_tail.prev = node;

            
            return node.val;
        }


        return -1;
    }
    
    public void put(int key, int value) {
        if( map.containsKey(key)){
            ListNode node = map.get(key);

            if(dummy_tail.prev == node){
                node.val = value;
                return;
            }

            ListNode prevNode = node.prev;
            ListNode nextNode = node.next;

            // remove updated node and add at last
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            ListNode prev_tail = dummy_tail.prev;
            prev_tail.next = node;
            node.prev = prev_tail;

            node.next = dummy_tail;
            dummy_tail.prev = node;

            node.val = value;

            return;
        }


        ListNode New_Node = new ListNode(key,value,null,null);

        if(counter < capacity){

            if(dummy_head.next == dummy_tail){
                dummy_head.next = New_Node;

                New_Node.prev = dummy_head;
                New_Node.next = dummy_tail;

                dummy_tail.prev = New_Node;

            }else{

                dummy_tail.prev.next = New_Node;
                New_Node.prev = dummy_tail.prev;

                New_Node.next = dummy_tail;
                dummy_tail.prev = New_Node;

            }
            map.put(key , New_Node);

            counter++;

        }else{
            

            //remove least recently used node (remove from start as well as from map)
            ListNode head = dummy_head.next;
            ListNode NextOfHead = head.next;
            dummy_head.next = NextOfHead;
            NextOfHead.prev = dummy_head;
            map.remove(head.key); // for this line we have used key in LL

            //add new node at MostRecently used (at end , also add in map)
            ListNode prev_tail = dummy_tail.prev;

            prev_tail.next = New_Node;
            New_Node.prev = prev_tail;

            New_Node.next = dummy_tail;
            dummy_tail.prev = New_Node;

            map.put(key , New_Node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
