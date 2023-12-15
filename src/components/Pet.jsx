import { usePetData } from "../hooks/pet/usePetData";
import { PetCard } from "./cards/PetCard";
import '../static/form.css'
import { Link } from "react-router-dom";

export function Pet(){
    const { data } = usePetData();
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h1>Pets</h1>
            <table>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Espécie</th>
                    <th>Sexo</th>
                    <th>Tutor</th>
                    <th>Ações</th>
                </tr>
                {data?.map(pet =>
                    <PetCard 
                        codigo={pet.codigo}
                        nome={pet.nome}
                        especie={pet.especie}
                        sexo={pet.sexo}
                        tutor={pet.tutor.nome}/>)}
            </table>
        </>
    )
}