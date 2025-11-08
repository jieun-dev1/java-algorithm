package leetcode;


import java.util.HashMap;

class Node {
    //각 노드의 자식 노드 저장
    HashMap<Character, Node> child;
    boolean endOfWord;

    public Node() {
        this.child =new HashMap<>();
        this.endOfWord = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }
    //for 문을 돌며, 한 문자씩 각 노드에 Child 값 확인 -> 1)있으면 child 로 이동. 2)없으면 이번 문자 노드를 생성 + 그 노드로 이동.
    public void insert(String str) {
        Node node = this.root;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            //트리노드가 비어있는 이유: 값을 채우는 목적 (x) 경로를 확보하기 위함.
            node.child.computeIfAbsent(c, k -> new Node());
            node = node.child.get(c);
        }
        node.endOfWord = true;
    } //삽입
    public boolean search(String str) {
        Node node = this.root;
        for (int i=0; i<str.length(); i++) {
         char c = str.charAt(i);
        if (node.child.containsKey(c)) {
            node = node.child.get(c);
        } else {
            return false;
        }
        }
        return node.endOfWord; //unless, if I am looking for bab and there's baby, it will return true. bab should return false here. Even when b's endOfWord is true, it will still iterate till baby.
    }
    //Trie 단어의 첫 글자는 항상 ROOt의 자식 노드.
    public boolean startsWith(String prefix) {
        Node node = this.root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.child.containsKey(c)) {
                node = node.child.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));

    }
}

