import { useEffect, useState } from "react";
import { Input } from "./Input";
import { Link, useNavigate } from "react-router-dom";
import { usePetDataMutate } from "../../hooks/pet/usePetDataMutate";

export function PetForm(){

    const [nome,setNome] = useState("");
    const [especie,setEspecie] = useState("");
    const [sexo,setSexo] = useState("");
    const [tutor,setTutor] = useState("");

    const { mutate,isSuccess } = usePetDataMutate();
    const navigate = useNavigate();

    const submit = () => {
        const petData = {
            nome,
            especie,
            sexo,
            tutor
        }
        mutate(petData)
    }

    useEffect(() => {
        if(isSuccess){
            return navigate("/")
        }
        else{
            console.log("Erro ao preencher os campos!")
        }
    },[isSuccess])
    return(
        <>
            <Link to="/" className="btn btn-light">Voltar</Link>
            <h2>Adicionar novo Pet</h2>
            <form action="">
                <Input label="Nome" value={nome} updateValue={setNome}/>
                <Input label="Espécie" value={especie} updateValue={setEspecie}/>
                <Input label="Sexo" value={sexo} updateValue={setSexo}/>
                <Input label="Tutor" value={tutor} updateValue={setTutor}/>
            </form>
            <Link onClick={submit} className="btn btn-success">Submit</Link>
        </>
    )
}