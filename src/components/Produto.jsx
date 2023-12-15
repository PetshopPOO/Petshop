import { useProdutoData } from "../hooks/produto/useProdutoData";
import { ProdutoCard } from "./cards/ProdutoCard";
import '../static/form.css'
import { Link } from "react-router-dom";

export function Produto(){
    const { data } = useProdutoData();
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h1>Produtos</h1>
            <table>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Preço</th>
                    <th>Estoque</th>
                    <th>Fornecedor</th>
                    <th>Ações</th>
                </tr>
                {data?.map(produto =>
                    <ProdutoCard 
                        codigo={produto.codigo}
                        nome={produto.nome}
                        preco={produto.preco}
                        estoque={produto.estoque}
                        fornecedor={produto.fornecedor}/>)}
            </table>
        </>
    )
}