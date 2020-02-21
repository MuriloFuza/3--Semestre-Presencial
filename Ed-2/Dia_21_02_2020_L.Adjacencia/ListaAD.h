#include <stdio.h>
#include <stdlib.h>

//estrutura de dados
typedef struct no
{
    int vert;
    struct no *prox; 
}NO;

typedef struct 
{
    NO **L;
    int N;
}LAD;//Lista Adjacente

//Operações
int CriaGrafoVazio(LAD *g);
int CriaGrafo    (LAD *g, int nvert);//nvert - Número de vertices
int InserirAresta(LAD *g, int vert1, int vert2);//passamos a origem e o destino para inserir a aresta
int RemoverAresta(LAD *g, int vert1, int vert2);//vert1 - vertice origem/vert2 - vertice destino
int ExisteAresta (LAD *g, int vert1, int vert2);
int GrauVertice  (LAD *g, int v);
int Vazio(LAD *g);
//Operações sem retorno
void VerticesAdjacentes(LAD *g,  int v);
void ExibeGrafo(LAD *g);
void Destruir  (LAD *g);
//função auxiliar
int VerticeValido(LAD *g, int v);