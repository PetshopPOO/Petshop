export function ProdutoCard({codigo, nome, preco, estoque, fornecedor}){   
    return(
        <>
            <tr>
                <td>{codigo}</td>
                <td>{nome}</td>
                <td>{preco}</td>
                <td>{estoque}</td>
                <td>{fornecedor}</td>
                <td><button className="btn btn-danger">Excluir</button></td>
            </tr>
        </>
    )
}