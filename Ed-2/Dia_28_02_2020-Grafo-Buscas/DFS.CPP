

void DFS(Grafo *G, int v)
{
    int Pilha[G->N];
    int visitados[G->N];
    for(int i =0;o<G->N;i++)
        {
            visitados[i] =0;
        }
    DFS_rec(G,Pilha,visitados,v,&fp);
}

int DFS_rec(Grafo *G, int P[], int visitado[], int v,int *fp)
{
        visitados[v]++;
        P[fp] = v;
        fp++;

        No* q = G->L[v];
        for(q=G->[v];q!=NULL;q=q->prox)
        {   
            if(visitados(q->vert)==0)//Criar visitados
            {
                printf("(%d,%d) - ",v,q->vert);
                DFS_rec(G,P,visitados,q->vert,fp);
            }

            if(EstaNaPilha(q->vert,P) && (P[fp-2] != q->vert))//Criar EstaNaPilha
                printf("(%d,%d) - ",v,q->vert);
        }//close for
        *fp--;
}//close DFS_rec