export function VendaCard({codigo,cliente,funcionario }){  
    return(
        <>
            <tr>
                <td>{codigo}</td>
                <td>{cliente}</td>
                <td>{funcionario}</td>
                <td><button className="btn btn-danger">Excluir</button></td>
            </tr>
        </>
    )
}