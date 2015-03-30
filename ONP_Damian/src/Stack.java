class Stack {
        private int maxStackSize;
        private Character[] stack;
        private int stackPeek;
 
        public Stack(int maxStackSize) {
                this.maxStackSize = maxStackSize;
                stack = new Character[maxStackSize];
                stackPeek = 0;
        }
 
        public void push(Character element) {
                stack[++stackPeek] = element;
        }
 
        public char pop() {
                return stack[stackPeek--];
        }
 
        public char peek() {
                return stack[stackPeek];
        }
 
        public boolean isEmpty() {
                return (stackPeek == 0);
        }
 
        public boolean isFull() {
                return (stackPeek == maxStackSize - 1);
        }
}
 