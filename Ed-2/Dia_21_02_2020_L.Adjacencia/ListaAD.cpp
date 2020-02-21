#include "ListaAD.h"

//Operações
int CriaGrafoVazio(LAD *g)
{
    g->N=0;
    return 1;
}

int CriaGrafo(LAD *g, int nvert)
{
    g->N=nvert;
    g->L = (NO**) malloc (nvert * sizeof(NO*));
    if(g->L==NULL) return 0;
    for(int i = 0;i<nvert;i++)
    {
        g->L[i] = NULL;
    }
    return 1;
}

int ExisteAresta (LAD *g, int vert1, int vert2)
{
    no *p;
    if(Vazio(g)) return 0;
    if(!VerticeValido(g,vert1) && !VerticeValido(g,vert2)) return 0; //caso um não seja valido retorna falso
    if(g->L[vert1] == NULL)
    {
        return 0;
    }
    p = g->L[vert1];
    while (p && p->vert != vert2)
    {
        p = p->prox;
    }
    if(p==NULL) return 0;
    return 1;
    
}

int VerticeValido(LAD *g, int v)
{
    if(v<0 || v>g->N) return 0;
}

int InserirAresta(LAD *g, int vert1, int vert2)
{
    if(Vazio(g)) return 0;
    if(ExisteAresta(g,vert1,vert2)) return 0;// se existir não insere

    //inserir no inicio --Inserindo v1-v2
    NO *p;
    p = (NO*) malloc (sizeof(NO));
    if(p==NULL) return 0;
    p->vert = vert2;
    p->prox = g->L[vert1];
    g->L[vert1] = p;

    //Inserir v2-v1

    p = (NO*) malloc (sizeof(NO));
    if(p==NULL) return 0;
    p->vert = vert1;
    p->prox = g->L[vert2];
    g->L[vert2] = p;
    
    return 1;

}


int RemoverAresta(LAD *g, int vert1, int vert2)
{
    NO *p, *q;
    if(!ExisteAresta(g,vert1,vert2)) return 0;
    p = g->L[vert1];
    q = NULL;

    //removendo aresta v1-v2
    while (p && p->vert != vert2)
    {
        q = p;
        p = p->prox;
    }
    if(q==NULL)
    {
        g->L[vert1]->prox = p->prox;
    }else
    {
        q->prox = p->prox;
    }
         free(p);    
    p = g->L[vert2];
    q = NULL;

   //removendo aresta v2-v1------
    while (p && p->vert !=vert1)
    {
        q = p;
        p = p->prox;
    }
    if(q==NULL)
    {
        g->L[vert2]->prox = p->prox;
    }else
    {
        q->prox = p->prox;
    }
         free(p);   
}

int GrauVertice(LAD *g, int v)
{
    //supondo que o vertice é valido;
    int cont  =0;
    NO *p = g->L[v];
    while (p)
    {
        cont++;
        p = p->prox;
    }
    

}

int Vazio(LAD *g)
{
    return(!g->N);
}


//-----------------------------------------------------------//
//Operações sem retorno
void VerticesAdjacentes(LAD *g,  int v)
{
    if(Vazio(g)) return;
    //supondo que o vertice é valido;
    NO *p = g->L[v];
    while (p)
    {
       printf("[%d]->",p->vert);
       p = p->prox;
    }
}

void ExibeGrafo(LAD *g)
{
    if(Vazio(g)) 
        printf("\nEsta vazio!");
    else
    {
        for (int i = 0; i < g->N; i++)
        {
            printf("\n(%d)->",i);
            NO *p = g->L[i];
            while (p)
            {
                printf("[%d]->",p->vert);
                p=p->prox;
            }
            
        }
        
    }
    
}

void Destruir  (LAD *g)
{
    if(Vazio(g)) return;
    NO *p, *q;
    for (int i = 0; i < g->N; i++)
    {
        p = g->L[i];
        while (p)
        {
            q = p;
            p = p->prox;
            free(q);
        }
    }
}