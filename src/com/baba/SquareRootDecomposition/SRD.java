package com.baba.SquareRootDecomposition;

public class SRD {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;
        int rootN = (int) Math.sqrt(n);
        int[] blocksArray = new int[rootN + 1];
        int block_id = -1;

        // Build a block array

        for (int i = 0; i < n; i++) {
            if (i % rootN == 0) {
                block_id++;
            }
            blocksArray[block_id] += arr[i];
        }
        System.out.println(query(blocksArray, arr, 2, 5, rootN));
        update(blocksArray,arr,2,10,rootN);
        System.out.println(query(blocksArray, arr, 2, 5, rootN));
    }

    private static int query(int[] blocksArray, int[] arr, int l, int r, int rootN) {
        int ans = 0;
        while (l < r && l != 0 && l % rootN != 0) {
            ans += arr[l];
            l++;
        }

        while (l + rootN <= r) {
            int block_id = l / rootN;
            ans += blocksArray[block_id];
            l += rootN;
        }

        while (l <= r) {
            ans += arr[l];
            l++;
        }
        return ans;
    }

    private static void update(int[] blocksArray, int[] arr, int i, int val, int rootN) {
        int block_id = i / rootN;
        blocksArray[block_id] += val - arr[i];
        arr[i] = val;
    }
}
