/*
                        Implementação de Grafos Parte 1 - Tipo Abstrato de Dado
Nome: Murilo Fuza
Git: https://github.com/MuriloFuza
Data: 21/02/2020
*/
#include "grafo.cpp"


int main()
{
    grafo g;
    int v1, v2, op = 0;
    int nv = 0;
    CriaGrafoVazio(&g);
    do
    {
        system("cls");
        printf("        \n\n                        GRAFO - Matriz de Adjacencia\n\n");
        printf("1   ->   Criar Grafo\n");
        printf("2   ->   Inserir Aresta\n");
        printf("3   ->   Exibir Grafo\n");
        printf("4   ->   Remover Aresta\n");
        printf("5   ->   Grau do vertice\n");
        printf("6   ->   Exibir Vertices Adjacentes\n");
        printf("7   ->   Destruir\n");
        printf("8   ->   Vazio\n");
        printf("0   ->   Sair\n");
        printf("op -> ");
        scanf("%d",&op);

            switch (op)
            {
            case 1:
                system("cls");
                printf("\n\nInsira o numero de vertices desejados: ");
                scanf("%d",&nv);
                if(CriaGrafo(&g,nv) == 1)
                printf("Criado!\n");
                system("pause");
                
                break;

            case 2:
                system("cls");
                printf("Insira a vertice 1: ");
                scanf("%d",&v1);
                printf("Insira a vertice 2: ");
                scanf("%d",&v2);
                if(InserirAresta(&g,v1,v2) == 1)
                printf("Inserido!\n");
                system("pause");
                break;

            case 3:
              system("cls");
                ExibeGrafo(&g);
                printf("\n");
                system("pause");
                break;

            case 4:
              system("cls");
                printf("Insira a vertice 1: ");
                scanf("%d",&v1);
                printf("Insira a vertice 2: ");
                scanf("%d",&v2);
                if(RemoverAresta(&g,v1,v2) == 1)
                printf("Removido\n");
                system("pause");
                break;

            case 5:
              system("cls");
                printf("Qual vertice deseja saber o grau: ");
                scanf("%d",&v1);
                printf("Grau de %d = %d",v1,GrauVertice(&g,v1));
                system("pause");
                break;

            case 6:
            system("cls");
            printf("Qual o vertice desejado: ");
            scanf("%d",&v1);
            VerticesAdjacentes(&g,v1);
            system("pause");
                break;

            case 7:
            Destruir(&g);
                break;

            case 8:
            system("cls");
                if(Vazio(&g) == 1)
                printf("Esta vazio!\n");
                else
                {
                    printf("Esta ocupado!\n");
                }
                system("pause");
                
                break;
       
            }
    } while (op != 0);
    

    return 0;
}

