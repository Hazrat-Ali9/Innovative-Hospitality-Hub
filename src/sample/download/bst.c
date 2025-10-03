#include <stdio.h>
#include <stdlib.h>

#define NULL 0

struct treeNode {
    int data;
    struct treeNode* left;
    struct treeNode* right;
};

typedef struct treeNode TN;

TN* root;

void init_tree() {
    root = NULL;
}

TN* createNode(int item) {
    TN* temp = (TN*)malloc(sizeof(TN));
    temp->data = item;
    temp->left = NULL;
    temp->right = NULL;
    return temp;
}

void print_tree_aux(TN* t, int depth) {
    if(t == NULL)
        return;

    print_tree_aux(t->right, depth+1);
    for(int i=0; i<depth; i++)
        printf("\t");
    printf("%d---------------------------------\n", t->data);
    print_tree_aux(t->left, depth+1);
}

void print_tree() {
    printf("Printing tree ************************************\n");
    print_tree_aux(root, 0);
    printf("Complete ************************************\n");
}

TN* insert_aux(TN* t, int item) {
    if(t == NULL) {
        return createNode(item);
    }

    if(item < t->data) {
        t->left = insert_aux(t->left, item);
        return t;
    }
    else {
        t->right = insert_aux(t->right, item);
        return t;
    }
}

void insert(int item) {
    root = insert_aux(root, item);
}

TN* search_aux(TN* t, int key) {
    if(t==NULL) return NULL;
    if(t->data == key) return t;
    else if(t->data > key)  return search_aux(t->left, key);
    else    return search_aux(t->right, key);
}

TN* search(int key) {
    return search_aux(root, key);
}

TN* Leftmost(TN* t) {
    // complete this function
    // write your code here
}

TN* Delete_aux(TN* t, int item) {
    // complete this function
    // write your code here
}

void Delete(int item) {
    // complete this function
    // write your code here
}

void print_preorder(TN* t) {
    if(t == NULL)
        return;

    printf("%d ", t->data); // root
    print_preorder(t->left); // left
    print_preorder(t->right); // right
}

void print_inorder(TN* t) {
    if(t == NULL)
        return;

    print_inorder(t->left); // left
    printf("%d ", t->data); // root
    print_inorder(t->right); // right
}

void print_postorder(TN* t) {
    if(t == NULL)
        return;

    print_postorder(t->left); // left
    print_postorder(t->right); // right
    printf("%d ", t->data); // root
}

int main() {
    init_tree();

    insert(50);
    insert(30);
    insert(60);
    insert(20);
    insert(15);
    insert(5);
    insert(45);
    insert(75);
    insert(40);
    insert(90);
    insert(65);
    insert(70);
    print_tree(root, 0);

    if(search(65) == NULL)
        printf("%d not found\n", 65);
    else
        printf("%d found\n", 65);

    if(search(95) == NULL)
        printf("%d not found\n", 95);
    else
        printf("%d found\n", 95);

    print_inorder(root);
    printf("\n");

    print_preorder(root);
    printf("\n");

    print_postorder(root);
    printf("\n");

    Delete(65);
    print_tree();

    Delete(70);
    print_tree();

    return 0;
}
