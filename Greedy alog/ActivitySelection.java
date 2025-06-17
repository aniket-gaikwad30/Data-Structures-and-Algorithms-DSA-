public class ActivitySelection {

    public static void selectActivities(int[] start, int[] finish) {
        int n = start.length;
        int[] selected = new int[n];
        int count = 0;

        // The first activity always gets selected
        selected[count++] = 0;

        // The last selected activity's finish time
        int lastFinishTime = finish[0];

        for (int i = 1; i < n; i++) {
            // If the start time of the current activity is greater than or equal to
            // the finish time of the last selected activity
            if (start[i] >= lastFinishTime) {
                selected[count++] = i;
                lastFinishTime = finish[i]; // Update the last finish time
            }
        }

        // Print the selected activities
        System.out.print("Selected activities: ");
        for (int i = 0; i < count; i++) {
            System.out.print(selected[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 5, 6, 8, 8};
        int[] finish = {2, 4, 6, 7, 9, 9, 10, 11};

        selectActivities(start, finish);
    }
}