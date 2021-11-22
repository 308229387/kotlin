package com.learn.algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MyClass {
    static LinkedList<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args){
//        permutation("abc");



        TreeNode temp = new TreeNode(3);
        temp.left = new TreeNode(4);
        temp.right = new TreeNode(5);
        temp.left.left = new TreeNode(6);
        temp.left.right = new TreeNode(7);
        temp.right.left = new TreeNode(8);
        temp.right.right = new TreeNode(9);


        pathSum(temp,16);
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    static void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }

}