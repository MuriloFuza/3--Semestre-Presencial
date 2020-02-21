#include "grafo.h"
//Grafo nao direcionado
//Operações
int CriaGrafoVazio(grafo *g)
{
    g->N=0;
}

int Vazio(grafo *g)
{
    return (g->N==0);
}

int CriaGrafo(grafo *g, int nvert)
{
    int i,j;
    g->N=nvert;
    g->M=(int**) malloc(nvert * sizeof (int*));
        if(g->M == NULL)//verifica se o espaço foi alocado
            {
                return 0;
            }          
    for( i = 0; i < nvert;i++)
    {
        g->M[i] = (int*) malloc(nvert * sizeof(int));
        if(g->M[i]==NULL) return 0;//verifica se o espaço foi alocado
    }

    for ( i = 0; i < nvert; i++)
    {
        for(j = 0 ; j < nvert; j++)
        {
            g->M[i][j] = 0;
        }
    }
    
    return 1;
}
int ExisteAresta (grafo *g, int vert1, int vert2)
{
    return (g->M[vert1][vert2]);
}

int InserirAresta(grafo *g, int vert1, int vert2)
{
     if(Vazio(g)) return 0;
    if(vert1 > g->N || vert2 > g->N || vert1 < 0 || vert2 < 0) return 0;//verifica se os vertices são validos

    if(ExisteAresta(g,vert1,vert2)) return 0;

    g->M[vert1][vert2] = 1;
    g->M[vert2][vert1] = 1;
    return 1;
}

int RemoverAresta(grafo *g, int vert1, int vert2)
{
     if(Vazio(g)) return 0;
    if(vert1 > g->N || vert2 > g->N || vert1 < 0 || vert2 < 0) return 0;//verifica se os vertices são validos

     if(!ExisteAresta(g,vert1,vert2)) return 0;

    g->M[vert1][vert2] = 0;
    g->M[vert2][vert1] = 0;
    return 1;
}

int GrauVertice  (grafo *g, int v)
{
     if(Vazio(g)) return 0;
    int cont = 0;
    if(v < 0 || v > g->N) return 0;
    
    for (int i = 0; i < g->N; i++)
    {
        if(g->M[v][i] == 1)
        {
            cont++;
        } 
    }
    return cont;
}

//Operações sem retorno
void VerticesAdjacentes(grafo *g,  int v)
{
    if(v < 0 || v > g->N) return;
    
    for (int i = 0; i < g->N; i++)
    {
        if(g->M[v][i] == 1)
        {
            printf("[%d] -> ",i);
        } 
    }
    
}
void ExibeGrafo(grafo *g)
{
    if(Vazio(g)) return;
    int i,j;
    for(i=0;i<g->N;i++)
    {
    printf("\n");
         for(j=0;j<g->N;j++)
        {
            printf("%d\t",g->M[i][j]);
        }
    }

   
}

void Destruir(grafo *g)
{
    int i;
    for(i=0;i<g->N;i++)
    {
        free(g->M[i]);
    }
    free(g->M);
}

