import Button from "react-bootstrap/Button";
import React from "react";
import {Level} from "../../model/Level";
import {CharacterAdd} from "./CharacterAdd";

import "./AccordionDetail.css"
import InputGroup from "react-bootstrap/InputGroup";
import FormControl from "react-bootstrap/FormControl";
import {Character} from "../../model/Character";
import {LevelWinDetails} from "../../model/LevelWinDetails";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";

type accordianDetailProps = {
    floorLevel: Level,
    charactersToAdd: Character[]
}

type accordianDetailNotPreviouslyWonProps = {
    setWinMode: () => null,
    charactersToAdd: Character[]
}

type accordianDetailPreviouslyWonProps = {
    characterLevelDetail: LevelWinDetails[],
}

const AccordionDetailNotPreviouslyWon = (props : accordianDetailNotPreviouslyWonProps) => {
    return (
        <div className={"AccordionDetail"}>
            <p >Not Previously Won, Please Select from Character List</p>
            <div className={"CharacterAdd"}>
                {props.charactersToAdd && props.charactersToAdd.map((character: Character) => {
                    return <CharacterAdd key={character.id} characterName={character.name} displayButton={true}/>
                })}
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

const AccordionDetailPreviouslyWon = (props : accordianDetailPreviouslyWonProps) => {
    return (
        <div className={"AccordionDetail"}>
            <div className={"CharacterAdd"}>
                <Container>
                    {props.characterLevelDetail && props.characterLevelDetail.map((levelDetail: LevelWinDetails) => {
                        return (
                            <Row>
                                <p>WondDate: {levelDetail.won_date}</p>
                                <p>Notes: {levelDetail.notes}</p>
                                {levelDetail.winning_characters && levelDetail.winning_characters.map((character: Character) => {
                                    return <CharacterAdd key={character.id} characterName={character.name} displayButton={false} />
                                })}

                            </Row>
                        )
                    })}
                </Container>
            </div>

        </div>
    )
}

export const AccordionDetail = (props: accordianDetailProps) => {
    console.log(props.floorLevel.previously_won)
    return (
        <div>
            {props.floorLevel.previously_won?.length !== 0 ?
                <AccordionDetailPreviouslyWon characterLevelDetail={props.floorLevel.previously_won} /> :
                <AccordionDetailNotPreviouslyWon charactersToAdd={props.charactersToAdd} setWinMode={() => null} />
            }
        </div>
    )
}