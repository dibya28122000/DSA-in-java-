class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        // Step 2: Sort capacity in descending order
        Arrays.sort(capacity);

        int boxesUsed = 0;

        // Step 3: Pick largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {

            totalApples -= capacity[i];
            boxesUsed++;

            if (totalApples <= 0) {
                return boxesUsed;
            }
        }

        return boxesUsed;
    }
}