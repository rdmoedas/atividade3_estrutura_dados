package com.rodolfo.atividade;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ________
 * RESPOSTA *
 * ________
 *
 * Ao final a FILA com 10 células ficou com os valores: [5, 4, 3, 2, 1, 10, 9, 8, 7, 6]
 * Isso aconteceu, pois, ao passarmos os dados da lista, na ordem de índice crescente, para uma pilha, embora a ordem
 * dos dados continue igual, ao retirarmos esses dados da pilha eles saíram na ordem LIFO (Last In First Out)
 * Por isso a ordem será invertida.
 *
 * Resumindo as Operações:
 * Primeira LISTA: [1, 2, 3, 4, 5]
 * Passando da LISTA >>> PILHA: [1, 2, 3, 4, 5]
 * Passando da PILHA >>> FILA: [5, 4, 3, 2, 1]
 *
 * Segunda LISTA: [6, 7, 8, 9, 10]
 * Passando da LISTA >>> PILHA: [6, 7, 8, 9, 10]
 * Passando da PILHA >>> FILA: [5, 4, 3, 2, 1, 10, 9, 8, 7, 6]
 */

public class AtividadeFila {
    public static void main(String[] args) {
        // Passo 1a, criado um array com 5 células
        int[] lista = new int[5];

        // Passo 1b, adicionamos os números [1, 2, 3, 4 e 5] no array criado.
        lista = lista = populaLista(1, 5);
        System.out.println("1) Lista preenchida: " + Arrays.toString(lista));

        // Passo 2a, inserindo os dados da lista na pilha recem criada.
        Stack<Integer> pilha = new Stack<>();
        pilha = transfereListaParaPilha(lista, pilha);

        // Passo 2b, removendo todos os dados da lista.
        System.out.println("2) Valores atuais da PILHA: " + pilha);

        System.out.println("Removendo dados da LISTA...");
        lista = null;
        System.out.println("Valores atuais da LISTA: " + lista);

        // Passo 3: Remova os dados da Pilha e insira-os em uma Fila (com 10 células);
        // Passo 3a: Criar uma fila com 10 posições (células).
        // Para limitar o tamanho da fila foi utilizado o método ArrayBlockingQueue
        ArrayBlockingQueue<Integer> fila = new ArrayBlockingQueue<Integer>(10);

        // Passo 3b: Remova os dados da Pilha e insira-os na Fila
        fila = transferePilhaParaFila(pilha, fila);
        System.out.println("Valores atuais da PILHA: " + pilha);
        System.out.println("3) Valores atuais da FILA: " + fila);

        // Passo 4: Insira os números [6, 7, 8, 9 e 10] na lista;
        int valorInicial = 6;
        lista = populaLista(6, 5);
        System.out.println("4) Valores atuais da LISTA: " + Arrays.toString(lista));

        // Passo 5: Repita os passos 2 e 3.
        // > Passo 5-2:
        pilha = transfereListaParaPilha(lista, pilha);
        System.out.println("5-2) Valores atuais da PILHA: " + pilha);

        System.out.println("Removendo dados da LISTA...");
        lista = null;
        System.out.println("Valores atuais da LISTA: " + lista);

        // > Passo 5-3:
        fila = transferePilhaParaFila(pilha, fila);
        System.out.println("5-3) Valores atuais da PILHA: " + pilha);

        // Passo 6: Exiba todos os números que foram inseridos na fila.
        System.out.println("6) Valores adicionados na FILA: " + fila);
    }

    public static Stack<Integer> transfereListaParaPilha(int[] list, Stack<Integer> stack) {
        System.out.println("Pilha gerada: " + stack);
        System.out.println("Inserindo dados da LISTA na PILHA...");
        for (int i = 0; i < list.length; i++) {
            stack.push(list[i]);
//            System.out.println("Inserindo na pilha o valor: " + lista[i]);
        }
        return stack;
    }

    public static ArrayBlockingQueue<Integer> transferePilhaParaFila(Stack<Integer> stack, ArrayBlockingQueue<Integer> queue) {
        System.out.println("Removendo dados da PILHA e inserindo-os na FILA...");
        int tamanhoInicialPilha = stack.size();
        for (int i = 1; i <= tamanhoInicialPilha; i++) {
            int valor = stack.pop();
            queue.add(valor);
            //  System.out.println("Adicionado o valor " + valor);
        }
        return queue;
    }

    public static int[] populaLista(int valorInicial, int quantidadeDeValores) {
        int[] lista = new int[quantidadeDeValores];
        for (int i = 0; i < quantidadeDeValores; i++) {
            lista[i] = valorInicial;
            valorInicial++;
        }
        return lista;
    }
}
