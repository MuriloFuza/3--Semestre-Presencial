#include <stdio.h>
#include <stdlib.h>
//estrutura de dados
typedef struct
{
    int **M; //Ponteiro que aponta na matriz
    int N; //Número de elementos - Ordem da Matriz
}grafo;//Matriz de adjacencia

//Operações
int CriaGrafoVazio(grafo *g);
int CriaGrafo    (grafo *g, int nvert);//nvert - Número de vertices
int InserirAresta(grafo *g, int vert1, int vert2);//passamos a origem e o destino para inserir a aresta
int RemoverAresta(grafo *g, int vert1, int vert2);//vert1 - vertice origem/vert2 - vertice destino
int ExisteAresta (grafo *g, int vert1, int vert2);
int GrauVertice  (grafo *g, int v);
int Vazio(grafo *g);
//Operações sem retorno
void VerticesAdjacentes(grafo *g,  int v);
void ExibeGrafo(grafo *g);
void Destruir  (grafo *g);
