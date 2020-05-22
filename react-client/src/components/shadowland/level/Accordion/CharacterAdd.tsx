import React from "react";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";

type CharacterAdd = {
    characterName: string,
    displayButton: boolean
}

export const CharacterAdd = (props: CharacterAdd) => {
    return (
        <div>
            <Card >
                <Card.Body>
                    <Card.Title>{props.characterName}</Card.Title>

                    {props.displayButton ? <Button variant="primary">Remove</Button> : null}
                </Card.Body>
            </Card>
        </div>
    )
}