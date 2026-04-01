class DynamicArray {

    private int[] arr;
    private int capacity;
    private int size;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {

        if(size == capacity){
            resize();
        }

        arr[size] = n;
        size++;

    }

    public int popback() {
        if(size > 0){
            size--;
        }

        return arr[size];
    }

    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];

        for(int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity; 
    }
}
