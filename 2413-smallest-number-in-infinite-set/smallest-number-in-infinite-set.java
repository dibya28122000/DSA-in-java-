class SmallestInfiniteSet {
    
    private PriorityQueue<Integer> heap;
    private HashSet<Integer> seen;
    private int current;

    public SmallestInfiniteSet() {
        heap=new PriorityQueue<>();
        seen=new HashSet<>();
        current=1;
        
    }
    
    public int popSmallest(){
        if(!heap.isEmpty()){
            int val=heap.poll();
            seen.remove(val);
            return val;
        }
        return current++;   
    }
    
    public void addBack(int num) {
        if(num<current && !seen.contains(num)){
            heap.offer(num);
            seen.add(num);
        }
    }
}

