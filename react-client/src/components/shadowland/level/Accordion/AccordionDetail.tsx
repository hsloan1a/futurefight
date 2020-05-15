import Button from "react-bootstrap/Button";
import React from "react";
import {Level} from "../../model/Level";
import {CharacterAdd} from "./CharacterAdd";

import "./AccordionDetail.css"
import InputGroup from "react-bootstrap/InputGroup";
import FormControl from "react-bootstrap/FormControl";

type accordianDetailProps = {
    floorLevel: Level
}

type accordianDetailNotPreviouslyWonProps = {
    setWinMode: () => null
}

const AccordionDetailNotPreviouslyWon = (props : accordianDetailNotPreviouslyWonProps) => {
    return (
        <div className={"AccordionDetail"}>
            <p >Not Previously Won, Please Select from Character List</p>
            <div className={"CharacterAdd"}>
                <CharacterAdd characterName={"test"} />
                <CharacterAdd characterName={"test"} />
                <CharacterAdd characterName={"test"} />
            </div>
            <div>
                <InputGroup>
                    <InputGroup.Prepend>
                        <InputGroup.Text>Notes</InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl as="textarea" aria-label="With textarea" />
                </InputGroup>
                <Button onClick={props.setWinMode} >Save Winning Chars</Button>
            </div>
        </div>
    )
}

export const AccordionDetail = (props: accordianDetailProps) => {
    return (
        <div>
            {props.floorLevel.previously_won?.length != 0 ?
                <p className={"AccordionDetail"}>Previous Won</p> :
                <AccordionDetailNotPreviouslyWon setWinMode={() => null} />
            }
        </div>
    )
}